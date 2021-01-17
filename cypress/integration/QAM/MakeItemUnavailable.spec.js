/// <reference types="Cypress"/>

describe("Make item unavailable",function(){
    it('Login as normal user',function(){
        cy.Login()

    })

    it('Check if item exists',function(){
        cy.get('.card-body').should('contain','test')
    })

    it("Logout from normal user account",function(){
        cy.Logout()
    })

    it('Login as admin',function(){
        cy.LoginAsAdmin();
    })

    it("Make item unavailable",function(){
        cy.get('.btn').last().click()
        cy.wait(300)
            
    })
    it('Logout from admin account',function(){
        cy.Logout()
        
    })
    it("Login as normal user again",function(){
        cy.Login()
    })
    it("Check if the item exists",function(){
        cy.contains('test').should('not.exist')
    })
})