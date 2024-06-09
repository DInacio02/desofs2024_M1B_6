# Implementação - Caso de Uso "Gestão de Contas de Utilizador e Permissões"

## Descrição do Caso de Uso

```
As an Admin
I want to manage user accounts and permissions
So that I can control access to sensitive information and functionalities within the website.
```

## Casos de Abuso

**Casos de Abuso:**

- **Exposição de Informações Sensíveis:** Um administrador pode alterar e expor informações sensíveis de utilizadores.

- **Elevação de Privilégios:** Um administrador pode alterar as suas próprias permissões ou as de outros utilizadores para obterem acesso indevido a funcionalidades ou informações restritas.

- **Negar Acesso de Utilizadores:** Um administrador pode eliminar contas de utilizadores ou alterar as suas permissões para negar o acesso a funcionalidades ou informações.

- **Spoofing de Credenciais de Utilizadores:** Um administrador pode utilizar credenciais de outros utilizadores para aceder fazer login em nome deles, roubando-lhes a sua conta.


## Conclusões

Após discussão com a equipa e confirmação com a professora, os casos de abuso identificados neste caso de uso só são vulnerabilidades se um atacante conseguir autenticar-se como administrador, ou seja, neste caso só é possível tentar mitigar a tentativa de log in (estudo realizado em outro Use Case), e não os privilégios do administrador.

