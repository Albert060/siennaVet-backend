package com.albert.veterinariatfm.app.modulos.fichas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FichaServiceTest {

    @Mock
    private FichaRepository fichaRepository;

    @InjectMocks
    private FichaService fichaService;

    private Ficha ficha;
    private FichaDTO fichaDTO;

    @BeforeEach
    void setUp() {
        ficha = new Ficha();
        ficha.setIdFicha(1L);
        ficha.setNombre("Bobby");
        ficha.setSexo("Macho");
        ficha.setEdad("3");
        ficha.setPeso("15.5");

        fichaDTO = new FichaDTO();
        fichaDTO.setIdFicha(1);
        fichaDTO.setNombre("Bobby");
        fichaDTO.setSexo("Macho");
        fichaDTO.setEdad("3");
        fichaDTO.setPeso("15.5");
    }

    @Test
    void testObtenerFichas_PaginationWithCustomQuery() {
        // Arrange
        List<FichaDTO> fichasList = Arrays.asList(fichaDTO);
        Page<FichaDTO> page = new PageImpl<>(fichasList);
        int offset = 0;
        int limit = 10;

        when(fichaRepository.findAllConRaza(any(PageRequest.class))).thenReturn(page);

        // Act
        List<FichaDTO> result = fichaService.obtenerFichas(offset, limit);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Bobby", result.get(0).getNombre());
        verify(fichaRepository, times(1)).findAllConRaza(PageRequest.of(offset, limit));
    }

    @Test
    void testObtenerPorId_ExistingFicha() {
        // Arrange
        when(fichaRepository.findById(1L)).thenReturn(Optional.of(ficha));

        // Act
        Ficha result = fichaService.obtenerPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Bobby", result.getNombre());
        verify(fichaRepository, times(1)).findById(1L);
    }

    @Test
    void testCrearFicha() {
        // Arrange
        when(fichaRepository.save(any(Ficha.class))).thenReturn(ficha);

        // Act
        Ficha result = fichaService.crearFicha(ficha);

        // Assert
        assertNotNull(result);
        assertEquals("Bobby", result.getNombre());
        verify(fichaRepository, times(1)).save(ficha);
    }

    @Test
    void testActualizarFicha() {
        // Arrange
        when(fichaRepository.save(any(Ficha.class))).thenReturn(ficha);

        // Act
        Ficha result = fichaService.actualizarFicha(fichaDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Bobby", result.getNombre());
        verify(fichaRepository, times(1)).save(any(Ficha.class));
    }

    @Test
    void testBorrarFicha() {
        // Arrange & Act
        fichaService.borrarFicha(1L);

        // Assert
        verify(fichaRepository, times(1)).deleteById(1L);
    }
}