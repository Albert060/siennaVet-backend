package com.albert.veterinariatfm.app.modulos.vets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VetServiceTest {

    @Mock
    private VetRepository vetRepository;

    @Mock
    private BCryptPasswordEncoder encoder;

    @InjectMocks
    private VetService vetService;

    private Vet vet;

    @BeforeEach
    void setUp() {
        vet = new Vet();
        vet.setIdVet(1L);
        vet.setNombre("Dr. Smith");
        vet.setApellido("Smith");
        vet.setTelefono("987654321");
        vet.setEmail("drsmith@example.com");
        vet.setContrasena("password123");
    }

    @Test
    void testObtenerVeterinarios_Pagination() {
        // Arrange
        List<Vet> vetsList = Arrays.asList(vet);
        Page<Vet> page = new PageImpl<>(vetsList);
        int offset = 0;
        int limit = 10;

        when(vetRepository.findAll(any(PageRequest.class))).thenReturn(page);

        // Act
        List<Vet> result = vetService.obtenerVeterinarios(offset, limit);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Dr. Smith", result.get(0).getNombre());
        verify(vetRepository, times(1)).findAll(PageRequest.of(offset, limit));
    }

    @Test
    void testObtenerPorId_ExistingVet() {
        // Arrange
        when(vetRepository.findById(1L)).thenReturn(Optional.of(vet));

        // Act
        Vet result = vetService.obtenerPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Dr. Smith", result.getNombre());
        verify(vetRepository, times(1)).findById(1L);
    }

    @Test
    void testCrearVeterinarios_EncodesPassword() {
        // Arrange
        String encodedPassword = "encodedPassword";
        when(encoder.encode("password123")).thenReturn(encodedPassword);
        when(vetRepository.save(any(Vet.class))).thenReturn(vet);

        // Act
        Vet result = vetService.crearVeterinarios(vet);

        // Assert
        assertNotNull(result);
        assertEquals("Dr. Smith", result.getNombre());
        verify(encoder, times(1)).encode("password123");
        verify(vetRepository, times(1)).save(vet);
    }

    @Test
    void testActualizarVeterinarios_EncodesPassword() {
        // Arrange
        String encodedPassword = "encodedPassword";
        when(encoder.encode("password123")).thenReturn(encodedPassword);
        when(vetRepository.save(any(Vet.class))).thenReturn(vet);

        // Act
        Vet result = vetService.actualizarVeterinarios(vet);

        // Assert
        assertNotNull(result);
        assertEquals("Dr. Smith", result.getNombre());
        verify(encoder, times(1)).encode("password123");
        verify(vetRepository, times(1)).save(vet);
    }

    @Test
    void testBorrarVeterinario() {
        // Arrange & Act
        vetService.borrarVeterinario(1L);

        // Assert
        verify(vetRepository, times(1)).deleteById(1L);
    }
}