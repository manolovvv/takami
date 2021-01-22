/// <reference types="Cypress"/>

describe("MakeNewRequest",function(){
    it('Login',function(){
       cy.Login();
    })

    it('AddThreeRodsInTheCart',function(){
        cy.get('#basic-nav-dropdown').click()
        cy.get('.dropdown-item').contains("Rods").click()
        cy.get(".card-text").get(".btn").last().click()
        cy.get(".btn").contains("Add item to cart").click()
        cy.get(".btn").contains("Add item to cart").click()
        cy.get(".btn").contains("Add item to cart").click()
    })

    it('AddTwoReelsInTheCart',function(){
        cy.get('#basic-nav-dropdown').click()
        cy.get('.dropdown-item').contains("Reels").click()
        cy.get(".card-text").get(".btn").last().click()
        cy.get(".btn").contains("Add item to cart").click()
        cy.get(".btn").contains("Add item to cart").click()
    })

    it('AddOneHookInTheCart',function(){
        cy.get('#basic-nav-dropdown').click()
        cy.get('.dropdown-item').contains("Hooks").click()
        cy.get(".card-text").get(".btn").last().click()
        cy.get(".btn").contains("Add item to cart").click()
    })

    it('Remove rod from the cart', function(){
        
        
        cy.visit('http://localhost:3000/myCart')
        cy.wait(50);
        cy.get('.btn').contains("Delete item from cart").last().click()
    })

    it('Remove rod from the cart', function(){
        cy.get('.btn').contains("Make a request").last().click()
    })

    it('Logout', function(){
        cy.Logout();
    })


    
})