Cypress.Commands.add("Login",()=>{
    
        cy.visit('http://localhost:3000/');
        cy.get('.btn').contains('Login').click();
        cy.get('input[placeholder="Enter Username"]').type("moni")
        cy.get('input[placeholder="Password"]').type("moni123")
        cy.get('button[type=submit]').contains("Login").click()
        cy.wait(100)
        cy.url().should('include',"/products");
        cy.reload();

})

Cypress.Commands.add("Logout",()=>{
        cy.get('.btn').contains('Logout').click();
        cy.visit('http://localhost:3000/')
       
})

Cypress.Commands.add("LoginAsAdmin",()=>{
        cy.visit('http://localhost:3000/');
        cy.get('.btn').contains('Login').click();
        cy.get('input[placeholder="Enter Username"]').type("admin")
        cy.get('input[placeholder="Password"]').type("admin1")
        cy.get('button[type=submit]').contains("Login").click()
        cy.wait(100)
        cy.url().should('include',"/products");
        cy.reload();
       
})