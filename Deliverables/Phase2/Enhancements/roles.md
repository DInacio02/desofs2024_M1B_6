### Utilização de roles no sistema

Foram adicionadas as roles ADMIN, MANAGER e USER ao sistema de forma a garantir maior segurança no acesso a endpoints sensíveis.

A política de autorização aos vários tipos de utilizador é uma de especificar aquilo a que podem aceder, em vez de especificar aquilo que não podem. Desta forma, no caso do desenvolvimento de novas funcionalidades é necessário especificar quem tem acesso em vez de todos terem acesso por padrão.

Estas mudanças podem verificar-se neste [pull request](https://github.com/DInacio02/desofs2024_M1B_6/pull/32).