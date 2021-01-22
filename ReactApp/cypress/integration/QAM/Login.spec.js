/// <reference types="Cypress"/>

describe("Login and Logout",function(){
    it('Login',function(){
        cy.visit('http://localhost:3000/');
        cy.get('.btn').contains('Login').click();
        cy.get('input[placeholder="Enter Username"]').type("moni")
        cy.get('input[placeholder="Password"]').type("moni123")
        cy.get('button[type=submit]').contains("Login").click()
        cy.wait(100)
        
        cy.url().should('include',"/products")
        

    })

    it('Logout',function(){
        cy.reload()
        cy.contains("Logout").click();
    })
})