package com.pa.patterns.memento.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class ShoppingCartControllerTest {
    private ShoppingCartController ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new ShoppingCartController();
    }

    @Test
    void addProduct() {
        assertEquals(0, ctrl.getProducts().size());
        ctrl.addProduct("Test product", 42.0);
        assertEquals(1, ctrl.getProducts().size());
    }

    @Test
    void reset() {
    }

    @Test
    void removeProduct() {
    }

    @Test
    void undo() {
    }

    @Test
    void getProducts() {
    }

    @Test
    void showAll() {
    }
}