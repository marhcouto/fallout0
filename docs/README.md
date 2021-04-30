# LPOO - Fallout: A post pandemic RPG

## Tabela de Conteúdos
(Vai ser o índice)

## Design
### Atributos
#### Contexto do Problema
Tanto o nosso personagem quanto os monstros que enfrentará terão atributos que governarão a aptidão para o combate, a capacide de auto-cura, etc.
Estes atributos também serão partilhados com as armas, que poderão exigir um valor mínimo para serem manuseadas.

#### _Design Pattern_
A solução de este problema passou pela criação de uma classe **_Attributes_** que irá ter todos os atributos que os personagens podem possuir e que as armas podem exigir. Se uma arma não exigir um determinado atributo ou o personagem não tiver um atributo, o seu valor é simplesmente zero. 
#### Implementação
<p align="center">
  <img width=650 src="images/attributes.svg">
</p>

#### Consequências
 - Respeito dos principios SOLID
 - Algumas armas e personagens (maioritariamente monstros) podem estar cientes de atributos que não possuem. Por exemplo, um monstro pode não ter inteligência e nesse caso o atributo está a zero quando podia não existir.