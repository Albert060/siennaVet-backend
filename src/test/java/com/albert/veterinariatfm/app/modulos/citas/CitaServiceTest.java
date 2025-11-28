package com.albert.veterinariatfm.app.modulos.citas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CitaServiceTest {

    @Mock
    private CitasRepository citasRepository;

    @InjectMocks
    private CitaService citaService;

    private Cita cita;

    @BeforeEach
    void setUp() {
        cita = new Cita();
        cita.setIdCita(1L);
        cita.setFecha("2023-01-01 10:00:00");
        cita.setDetalles("Consulta de rutina");
        cita.setIdFicha(1L);
        cita.setIdVet(2L);
    }

    @Test
    void testObtenerCitas() {
        // Arrange
        List<Cita> citasList = Arrays.asList(cita);
        when(citasRepository.findAll()).thenReturn(citasList);

        // Act
        List<Cita> result = citaService.obtenerCitas();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Consulta de rutina", result.get(0).getDetalles());
        verify(citasRepository, times(1)).findAll();
    }

    @Test
    void testObtenerPorId_ExistingCita() {
        // Arrange
        when(citasRepository.findById(1L)).thenReturn(Optional.of(cita));

        // Act
        Cita result = citaService.obtenerPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Consulta de rutina", result.getDetalles());
        verify(citasRepository, times(1)).findById(1L);
    }

    @Test
    void testCrearCita() {
        // Arrange
        when(citasRepository.save(any(Cita.class))).thenReturn(cita);

        // Act
        Cita result = citaService.crearCita(cita);

        // Assert
        assertNotNull(result);
        assertEquals("Consulta de rutina", result.getDetalles());
        verify(citasRepository, times(1)).save(cita);
    }

    @Test
    void testActualizarCita() {
        // Arrange
        when(citasRepository.save(any(Cita.class))).thenReturn(cita);

        // Act
        Cita result = citaService.actualizarCita(cita);

        // Assert
        assertNotNull(result);
        assertEquals("Consulta de rutina", result.getDetalles());
        verify(citasRepository, times(1)).save(cita);
    }

    @Test
    void testBorrarCita() {
        // Arrange & Act
        citaService.borrarCita(1L);

        // Assert
        verify(citasRepository, times(1)).deleteById(1L);
    }
}