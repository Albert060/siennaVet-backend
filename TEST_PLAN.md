# Plan de Pruebas para la Aplicación VeterinariaTFM

## Descripción General

Este documento describe el plan de pruebas para la aplicación veterinaria, identificando los métodos y funcionalidades críticas que requieren cobertura de pruebas exhaustiva. El plan se centra en las operaciones más importantes del sistema que podrían afectar la integridad de los datos y la funcionalidad general.

## Funcionalidades Críticas

### 1. Gestión de Clientes

#### Métodos Críticos:
- `ClienteService.obtenerClientes(int offset, int limit)` - Paginación de clientes
- `ClienteService.obtenerPorId(Long id)` - Recuperación de cliente por ID
- `ClienteService.crearCliente(Cliente cliente)` - Creación de nuevos clientes
- `ClienteService.actualizarCliente(Cliente cliente)` - Actualización de clientes
- `ClienteService.borrarCliente(Long id)` - Eliminación de clientes

#### Consideraciones:
- Verificar la correcta paginación con offset y limit
- Validar la integridad de los datos durante la creación y actualización
- Confirmar que las operaciones de eliminación sean seguras y no afecten datos relacionados

### 2. Gestión de Veterinarios

#### Métodos Críticos:
- `VetService.obtenerVeterinarios(int offset, int limit)` - Paginación de veterinarios
- `VetService.obtenerPorId(Long id)` - Recuperación de veterinario por ID
- `VetService.crearVeterinarios(Vet veterinario)` - Creación de nuevos veterinarios
- `VetService.actualizarVeterinarios(Vet veterinario)` - Actualización de veterinarios
- `VetService.borrarVeterinario(Long id)` - Eliminación de veterinarios

#### Consideraciones:
- Validar el cifrado adecuado de contraseñas
- Verificar la correcta paginación con offset y limit
- Asegurar que las credenciales sean seguras durante la creación/actualización

### 3. Gestión de Fichas (Registros de Animales)

#### Métodos Críticos:
- `FichaService.obtenerFichas(int offset, int limit)` - Paginación con join personalizado
- `FichaService.obtenerPorId(Long id)` - Recuperación de ficha por ID
- `FichaService.crearFicha(Ficha ficha)` - Creación de nuevas fichas
- `FichaService.actualizarFicha(Ficha ficha)` - Actualización de fichas
- `FichaRepository.findAllConRaza(PageRequest pageRequest)` - Consulta personalizada con join

#### Consideraciones:
- Probar la consulta personalizada que combina fichas con razas
- Validar la correcta paginación de registros
- Verificar la integridad referencial entre fichas y razas/clientes

### 4. Gestión de Citas

#### Métodos Críticos:
- `CitaService.obtenerCitas()` - Recuperación de todas las citas
- `CitaService.obtenerPorId(Long id)` - Recuperación de cita por ID
- `CitaService.crearCita(Cita cita)` - Creación de nuevas citas
- `CitaService.actualizarCita(Cita cita)` - Actualización de citas
- `CitaService.borrarCita(Long id)` - Eliminación de citas

#### Consideraciones:
- Validar la correcta asociación entre fichas y veterinarios
- Verificar que no se permitan conflictos de horario duplicados
- Asegurar la integridad de los datos relacionales

## Estrategia de Pruebas

### 1. Pruebas Unitarias
- **Objetivo**: Probar cada método individualmente
- **Herramientas**: JUnit 5, Mockito
- **Enfoque**: Mock de dependencias externas para aislamiento
- **Cobertura**: Todos los métodos críticos mencionados

### 2. Pruebas de Integración
- **Objetivo**: Probar la interacción entre componentes
- **Herramientas**: Spring Boot Test, @DataJpaTest
- **Enfoque**: Validar la integración entre servicios y repositorios
- **Cobertura**: Consultas personalizadas y operaciones de base de datos

### 3. Pruebas de Paginación
- **Objetivo**: Validar la funcionalidad de paginación
- **Estrategia**: Probar diferentes combinaciones de offset y limit
- **Validaciones**: Resultados esperados, manejo de límites extremos
- **Consideraciones**: Rendimiento con grandes volúmenes de datos

### 4. Pruebas de Consultas Personalizadas
- **Objetivo**: Validar consultas SQL personalizadas
- **Estrategia**: Probar la consulta `findAllConRaza` que utiliza JOIN
- **Validaciones**: Resultados correctos, manejo de datos nulos
- **Consideraciones**: Uso de base de datos en memoria (H2) para pruebas

## Cobertura de Pruebas

### Clases de Prueba Implementadas:
- `ClienteServiceTest` - Pruebas para gestión de clientes
- `VetServiceTest` - Pruebas para gestión de veterinarios
- `FichaServiceTest` - Pruebas para gestión de fichas
- `CitaServiceTest` - Pruebas para gestión de citas
- `ClienteControllerTest` - Pruebas para endpoints de clientes
- `FichaRepositoryTest` - Pruebas para consultas personalizadas
- `TestSuite` - Suite para ejecución conjunta de pruebas

### Patrón AAA (Arrange-Act-Assert):
- **Arrange**: Preparación del entorno de prueba
- **Act**: Ejecución del método a probar
- **Assert**: Verificación de los resultados esperados

## Configuración del Entorno de Pruebas

### Dependencias:
- Spring Boot Starter Test (JUnit, Mockito, AssertJ)
- JUnit Platform Suite para test suites
- H2 Database para pruebas de integración
- Mockito para mocking de dependencias

### Configuración de Pruebas:
- Uso de `@BeforeEach` para inicialización de datos de prueba
- Implementación de `@AutoConfigureTestDatabase` para usar base de datos en memoria
- Configuración de `@DataJpaTest` para pruebas de repositorio

## Validación y Ejecución

### Ejecución de Pruebas:
- Ejecutar vía Maven: `mvn test`
- Integración con CI/CD para ejecución automática
- Ejecución individual de suites con `TestSuite`

### Métricas de Calidad:
- 100% cobertura de métodos críticos
- Pruebas pasando consistentemente
- Validación de casos límite y errores esperados