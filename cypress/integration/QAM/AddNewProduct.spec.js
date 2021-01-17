/// <reference types="Cypress"/>

describe("Add new product",function(){
    it('Login as an admin',function(){
        cy.LoginAsAdmin();
        

    })

    it('Go to add new item page',function(){
        cy.get('.nav-link').contains("Add new product").click()
    })

    it('Add new product', function(){
        cy.get('input[placeholder="Name"]').type('test')
        cy.get('input[placeholder="Description"]').type("test/testt")
        cy.get('.btn').contains("Add product").click()
    })

    it('Check the new product if exists',function(){
        cy.get('.navbar-brand').contains('Takami').click()
        cy.contains("test").should('exist')
    })

    it("Logout",function(){
        cy.Logout()
    })
})