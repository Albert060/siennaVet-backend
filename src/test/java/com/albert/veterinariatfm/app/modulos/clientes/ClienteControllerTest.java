package com.albert.veterinariatfm.app.modulos.clientes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void testMostrarClientes_Controller() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("John");
        cliente.setApellido("Doe");
        List<Cliente> clientesList = Arrays.asList(cliente);

        when(clienteService.obtenerClientes(0, 10)).thenReturn(clientesList);

        // Act
        List<Cliente> result = clienteController.mostrarClientes(0, 10);

        // Assert
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getNombre());
        verify(clienteService, times(1)).obtenerClientes(0, 10);
    }

    @Test
    void testMostrarPorId_Controller() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("John");
        cliente.setApellido("Doe");

        when(clienteService.obtenerPorId(1L)).thenReturn(cliente);

        // Act
        Cliente result = clienteController.mostrarPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getNombre());
        verify(clienteService, times(1)).obtenerPorId(1L);
    }

    @Test
    void testCrearCliente_Controller() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("John");
        cliente.setApellido("Doe");

        when(clienteService.crearCliente(any(Cliente.class))).thenReturn(cliente);

        // Act
        Cliente result = clienteController.crearCliente(cliente);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getNombre());
        verify(clienteService, times(1)).crearCliente(cliente);
    }
}