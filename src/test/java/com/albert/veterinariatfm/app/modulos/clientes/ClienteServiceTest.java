package com.albert.veterinariatfm.app.modulos.clientes;

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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("John");
        cliente.setApellido("Doe");
        cliente.setTelefono("123456789");
        cliente.setDireccion("123 Main St");
    }

    @Test
    void testObtenerClientes_Pagination() {
        // Arrange
        List<Cliente> clientesList = Arrays.asList(cliente);
        Page<Cliente> page = new PageImpl<>(clientesList);
        int offset = 0;
        int limit = 10;

        when(clienteRepository.findAll(any(PageRequest.class))).thenReturn(page);

        // Act
        List<Cliente> result = clienteService.obtenerClientes(offset, limit);

        // Assert
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getNombre());
        verify(clienteRepository, times(1)).findAll(PageRequest.of(offset, limit));
    }

    @Test
    void testObtenerPorId_ExistingCliente() {
        // Arrange
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        // Act
        Cliente result = clienteService.obtenerPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testCrearCliente() {
        // Arrange
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        // Act
        Cliente result = clienteService.crearCliente(cliente);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testActualizarCliente() {
        // Arrange
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        // Act
        Cliente result = clienteService.actualizarCliente(cliente);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testBorrarCliente() {
        // Arrange & Act
        clienteService.borrarCliente(1L);

        // Assert
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}