Feature: Purchase the dress with lowest price

Scenario Outline:verify user is able login to the portal and purchase the searched dress with lowest price.
Given User is login with "<email>" and "<password>"
When user search with keyword "dresses" and add to cart the lowest price dress
Then lowest price dress is added to cart


Examples:
|email                  |password |            
|ayashabodele@gmail.com |London@24|



