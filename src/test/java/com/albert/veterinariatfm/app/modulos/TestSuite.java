package com.albert.veterinariatfm.app.modulos;

import com.albert.veterinariatfm.app.modulos.clientes.ClienteControllerTest;
import com.albert.veterinariatfm.app.modulos.clientes.ClienteServiceTest;
import com.albert.veterinariatfm.app.modulos.citas.CitaServiceTest;
import com.albert.veterinariatfm.app.modulos.fichas.FichaRepositoryTest;
import com.albert.veterinariatfm.app.modulos.fichas.FichaServiceTest;
import com.albert.veterinariatfm.app.modulos.vets.VetServiceTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ClienteServiceTest.class,
    ClienteControllerTest.class,
    VetServiceTest.class,
    FichaServiceTest.class,
    FichaRepositoryTest.class,
    CitaServiceTest.class
})
public class TestSuite {
    // This class serves as a test suite to run all tests together
}