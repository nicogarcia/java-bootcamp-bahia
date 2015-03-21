# Globant Java Bootcamp's final project

**Live Demo**: [El Mago shopping cart](http://elmago-nicoxr4.rhcloud.com)

The objective of the final project was to make a shopping cart REST api prototype with user login, cart storage, buying and finding products as minimum features.

Although the project includes an UI to interact and test the REST api, it is far from production state and has a lot to improve taking in account that the whole project was made in around 10 days.

The look and feel and the information of the site is based on a real business, but the information is **NOT** official.

## Shopping cart architecture

![](https://cloud.githubusercontent.com/assets/241306/6762189/85f288f0-cf3a-11e4-9004-55bb3ba22206.png)

### [Server side](https://github.com/nicogarcia/java-bootcamp-bahia/tree/final/src/final/ElMagoWebServer)
#### Development tools
* **IDE**: IntelliJ IDEA
* **Build**: Maven (Spring Actuator Archetype used)
* **Framework**: Spring, with Spring Security and Hibernate ORM
* **Database**: MySql

#### Design
* **Three layer design**: Presentation, Service and Persistence
* **REST Architecture**

#### Features
* **Finding products and offers by name and category**
* **OAuth authentication**
* **User registration**
* **Customizable discounts**
* **Customizable payment methods**
* **Buy order creation**
* **Buy order listing and paying**
* **Saving and loading cart**

### [Client side](https://github.com/nicogarcia/java-bootcamp-bahia/tree/final/src/final/ElMagoWebClient)
#### Development tools
* **IDE**: Webstorm
* **Web Template**: [E-Shop template](http://themifycloud.com/demos/templates/eshop/index.html)
* **Scaffolding**: Yeoman
* **Build**: Grunt
* **Framework**: AngularJS

#### Features
* **Finding products and offers**
* **Adding products to cart**
* **Buy the items of the cart**
* **View orders**
* **Pay orders**

## Deployment
The deployment of the project was made to Openshift Cloud using a DIY cartidge.
The configuration of the cartidge was based on [Spring - Openshift](http://docs.spring.io/spring-boot/docs/current/reference/html/cloud-deployment-openshift.html)
Configuration is located in [Openshift configuration folder](https://github.com/nicogarcia/java-bootcamp-bahia/tree/final/src/final/ElMagoWebServer/.openshift)