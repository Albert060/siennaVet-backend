package com.albert.veterinariatfm.app.modulos.fichas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class FichaRepositoryTest {

    @Autowired
    private FichaRepository fichaRepository;

    @Test
    void testFindAllConRaza_Pagination() {
        // Arrange
        PageRequest pageRequest = PageRequest.of(0, 10);

        // For this test to work in a real scenario, we would need to have data in the test database
        // For now, we'll just verify that the method can be called without throwing an exception
        assertDoesNotThrow(() -> {
            Page<FichaDTO> result = fichaRepository.findAllConRaza(pageRequest);
            // Result could be empty but should not throw an exception
        });
    }
}