/// <reference types="Cypress"/>

describe("Login and Logout",function(){
    it("Register",function(){
        cy.visit('http://localhost:3000/');
        cy.get('.btn').contains('Register').click()
        cy.get('input[placeholder="Enter Username"]').type("test")
        cy.get('input[placeholder="Password"]').type("test1")
        cy.get('input[placeholder="Email"]').type("test@test.ds")
        cy.get('input[placeholder="First name"]').type("Test")
        cy.get('input[placeholder="Family name"]').type("Testing")
        cy.get('input[placeholder="Address"]').type("Breda")
        cy.get('button[type="submit"]').contains('Register').click()
        cy.wait(200)

    })


    it('Login',function(){
        cy.visit('http://localhost:3000/');
        cy.get('.btn').contains('Login').click();
        cy.get('input[placeholder="Enter Username"]').type("test")
        cy.get('input[placeholder="Password"]').type("test1")
        cy.get('button[type=submit]').contains("Login").click()
        cy.wait(100)
        
        cy.url().should('include',"/products")
        

    })

    it('Logout',function(){
        cy.reload()
        cy.contains("Logout").click();
    })
})