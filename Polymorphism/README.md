# Polymorphism implementation

This program displays the importance of utilizing the polymorphism in Java.
There is abstract class Figure, that describes the functionality of figure, like getSquare and getPerimeter. Also, it has private attribute 'type' that stores the type of Figure realization. It can be initialized only through Figure constructor.
Figure has two derivative classes: Circle and Rectangle. They implement methods with their own specification. There is also class Square that extends Rectangle and have no personal implementations of methods.

## Comparable interface

To learn implementation of interface 'Comparable', Figure implements it and comparing figures with their squares. So then any collection of Figure elements can be organized or sorted.

Here is PUML diagram of hierarchy of the program:

![PUML diagram](https://cdn-0.plantuml.com/plantuml/png/NP11JWCn34NtFaMMe55wW8f5fKgi4Uq5tCI4I9bCSHmXDFJkc1e6fgl4B__RtzarGPO-5iXLY5ymaDjFunaPJuNS34EuLdISxkxX0e2d9en1N2ZOcdlCgVEtpil7cRRk89nhWY6H71Me1uRvrtDHUdZhoCfly1Dn7ac8ROertsSErn2UCURUjYvENMFzAPuf2DPaea8roUiYykyvMhdsM08tA_YtwSFdPlEp3TYXo7lBi4RBK5Xkzc2TOKSrwez-0G00)
