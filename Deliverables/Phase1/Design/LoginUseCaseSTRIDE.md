# Determinar Ameaças - Caso de Uso de Login

De forma a determinar as ameaças existentes no caso de uso de login irá ser utilizado a mnemônica STRIDE, e a sua lista de possíveis ameaças.

## Descrição do Caso de Uso

```
As a User
I want to be able to login with my credentials
So that I can use the application
```

## Possíveis Ameaças no Caso de Uso

Através da lista de ameaças STRIDE é possível identificar 1 possívil ameaça providiente da tentativa do user fazer login com as suas credenciais.

- Uma ameaça Spoofing onde o hacker tenta aceder às credenciais do utilizador de alguma forma.

## Análise das Ameaças

### Spoofing

![Login-Threat Tree Diagram.png](..%2FDesign%2FLogin-Threat%20Tree%20Diagram.png)

Como é possível observar o diagrama acima o Hacker pode tentar através de diversas formas fazer login na conta de um utilizador, como é o exemplo o misuse case onde é possível através de tentativa e erro tentar descobrir a conta de alguém.
Mas é possível combater esses misuse cases com as tecnicas de mitigação descritas nos quadrados azuis.

#### Nota:  A análise STRIDE deste documento apenas cobre como o hacker pode abusar do caso de uso de Login. Outras ameaças que seriam possiveis dependendo da conta que o Hacker consiga aceder serão descritas nos .md especificos do caso de uso referente a essa ameaça.
