# 🐺 Witcher Microservices - Sistema de Contratos e Bestiário

> *"Toss a coin to your Witcher, O' Valley of Plenty!"* 🪙

Bem-vindos ao **Witcher Microservices**, um sistema distribuído inspirado no universo de The Witcher, onde bruxos podem gerenciar seus contratos, consultar o bestiário e organizar seu arsenal de forma eficiente e segura.

## 📖 Sobre o Projeto

Este projeto implementa uma arquitetura de microserviços completa, simulando o ecossistema de um bruxo profissional. Assim como Geralt de Rívia precisa de suas espadas, poções e conhecimento sobre monstros para cumprir contratos, nossa aplicação oferece todos os serviços necessários para gerenciar essa complexa operação.

### 🎯 Analogia com o Universo The Witcher

- **🏰 Service Discovery (Eureka)**: Como as tavernas onde bruxos se encontram e trocam informações
- **🛡️ API Gateway**: O portão de Kaer Morhen, controlando quem entra e sai
- **🔐 Auth Service**: O Código dos Bruxos, garantindo que apenas bruxos autenticados acessem os recursos
- **📚 Bestiary Service**: O conhecimento ancestral sobre monstros e itens mágicos
- **📜 Contracts Service**: O sistema de contratos da Guilda dos Bruxos
- **🗃️ PostgreSQL**: Os arquivos da biblioteca de Oxenfurt
- **📨 Kafka**: Os corvos mensageiros que levam notícias entre as cidades

## 🏗️ Arquitetura do Sistema

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   API Gateway   │────│ Service Discovery│────│   Auth Service  │
│   (Port 8765)   │    │   (Port 8761)   │    │   (Port 8766)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                                              │
         ├──────────────────┬─────────────────────────────┤
         │                  │                             │
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ Bestiary Service│    │Contracts Service│    │   PostgreSQL    │
│   (Port 8100)   │    │   (Port 8200)   │    │   (Port 5432)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                              │
                    ┌─────────────────┐
                    │      Kafka      │
                    │   (Port 9092)   │
                    └─────────────────┘
```

## 🚀 Tecnologias Utilizadas

### Backend
- **Java 17** - A linguagem dos mestres bruxos
- **Spring Boot 3.3.1** - O framework que une todos os feitiços
- **Spring Cloud Gateway** - O guardião dos portões
- **Spring Security + JWT** - A proteção mágica dos endpoints
- **Spring Data JPA** - O grimório de persistência
- **Netflix Eureka** - O sistema de descoberta de serviços
- **OpenFeign** - A comunicação telepática entre serviços
- **Apache Kafka** - O sistema de mensageria assíncrona

### Infraestrutura
- **Docker & Docker Compose** - Os portais mágicos de deployment
- **PostgreSQL** - O banco de dados dos sábios
- **Swagger/OpenAPI** - A documentação dos encantamentos

## 🛠️ Funcionalidades

### 🔐 Serviço de Autenticação (Auth Service)
- **Registro de Bruxos**: Cadastro de novos usuários no sistema
- **Login Seguro**: Autenticação com geração de tokens JWT
- **Gestão de Roles**: Controle de permissões baseado em papéis

### 📚 Serviço de Bestiário (Bestiary Service)
- **Catálogo de Itens**: Gerenciamento de espadas, poções e equipamentos
- **Catálogo de Monstros**: Registro completo de criaturas do universo The Witcher
- **CRUD Completo**: Criação, leitura, atualização e exclusão para itens e monstros
- **Tipos de Itens**: Classificação entre WEAPON, POTION, ARMOR, etc.
- **Tipos de Monstros**: 11 categorias incluindo NECROPHAGE, SPECTER, VAMPIRE, etc.
- **Validação de Negócio**: Regras específicas para cada tipo de entidade
- **DTOs Otimizados**: Diferentes DTOs para criação, atualização e consulta

### 📜 Serviço de Contratos (Contracts Service)
- **CRUD Completo**: Criação, leitura, atualização e exclusão de contratos
- **Gestão de Status**: Controle do ciclo de vida dos contratos (PENDING, ACCEPTED, IN_PROGRESS, COMPLETED, CANCELLED, FAILED)
- **Validação de Itens**: Verificação automática se os itens necessários existem no bestiário
- **Persistência**: Contratos salvos no PostgreSQL com timestamps automáticos
- **Filtros Avançados**: Busca por status e ID do monstro
- **Integração com Kafka**: Notificações assíncronas sobre eventos de contratos
- **Comunicação Segura**: Integração autenticada com o Bestiary Service

## 🐳 Como Executar o Projeto

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 17+ (para desenvolvimento local)
- Maven 3.9+ (para build local)

### 1. Clone o Repositório
```bash
git clone <repository-url>
cd witcher-microservices
```

### 2. Configure as Variáveis de Ambiente
Crie um arquivo `.env` na raiz do projeto:
```env
POSTGRES_USER=witcher_user
POSTGRES_PASSWORD=witcher_password
JWT_SECRET=your-super-secret-jwt-key-for-development-change-in-production
JWT_EXPIRATION=86400000
```

### 3. Execute com Docker Compose
```bash
# Subir todos os serviços
docker-compose up -d

# Verificar status dos serviços
docker-compose ps

# Ver logs de um serviço específico
docker-compose logs -f bestiary-and-armory-app
```

### 4. Aguarde a Inicialização
Os serviços podem levar alguns minutos para inicializar completamente. Monitore os logs para confirmar que todos estão funcionando.

### 5. Carregue os Dados de Exemplo (Opcional)
```bash
# Navegue para o diretório de dados
cd data

# Execute o script para carregar dados de exemplo
load-data.bat
```

Este script carrega:
- **15 itens** (espadas, poções, armaduras)
- **10 monstros** (grifos, vampiros, necrófagos, etc.)
- **5 contratos** com diferentes status e itens requeridos

## 🌐 Endpoints e Documentação

### Swagger UI (Interface Unificada)
- **URL**: http://localhost:8765/webjars/swagger-ui/index.html
- **Descrição**: Interface única para testar todos os serviços

### Serviços Individuais
| Serviço | URL | Swagger |
|---------|-----|---------|
| API Gateway | http://localhost:8765 | http://localhost:8765/webjars/swagger-ui/index.html |
| Auth Service | http://localhost:8766/api | http://localhost:8766/swagger-ui.html |
| Bestiary Service | http://localhost:8100/api | http://localhost:8100/swagger-ui.html |
| Contracts Service | http://localhost:8200/api | http://localhost:8200/swagger-ui.html |
| Eureka Dashboard | http://localhost:8761 | - |

### Endpoints Principais

#### Bestiary Service
- `GET /api/items` - Listar todos os itens
- `POST /api/items` - Criar novo item
- `PUT /api/items/{id}` - Atualizar item
- `DELETE /api/items/{id}` - Remover item
- `GET /api/monsters` - Listar todos os monstros
- `POST /api/monsters` - Criar novo monstro
- `PUT /api/monsters/{id}` - Atualizar monstro
- `DELETE /api/monsters/{id}` - Remover monstro

#### Contracts Service
- `GET /api/contracts` - Listar todos os contratos
- `POST /api/contracts` - Criar novo contrato
- `GET /api/contracts/{id}` - Buscar contrato por ID
- `PUT /api/contracts/{id}/status` - Atualizar status do contrato
- `DELETE /api/contracts/{id}` - Remover contrato
- `GET /api/contracts/status/{status}` - Filtrar por status

## 🔑 Como Usar a Autenticação

### 1. Registrar um Novo Bruxo
```bash
curl -X POST http://localhost:8766/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "geralt_of_rivia",
    "password": "12345678"
  }'
```

### 2. Fazer Login
```bash
curl -X POST http://localhost:8766/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "geralt_of_rivia",
    "password": "12345678"
  }'
```

### 3. Usar o Token JWT
Copie o token retornado e use no header `Authorization: Bearer <token>` para acessar endpoints protegidos.

### 4. No Swagger UI
1. Faça login no Auth Service
2. Copie o token retornado
3. Nos outros serviços, clique em "Authorize"
4. Cole o token (sem "Bearer ")
5. Teste o endpoint `/api/auth/validate` para confirmar se o token está válido

## 📊 Monitoramento e Saúde

### Health Checks
Todos os serviços expõem endpoints de saúde:
- http://localhost:8100/actuator/health (Bestiary)
- http://localhost:8200/actuator/health (Contracts)
- http://localhost:8766/actuator/health (Auth)
- http://localhost:8765/actuator/health (Gateway)

### Endpoints de Validação de Token
Para testar se o token JWT está válido:
- http://localhost:8100/api/auth/validate (Bestiary)
- http://localhost:8200/api/auth/validate (Contracts)

### Eureka Dashboard
Monitore o registro de serviços em: http://localhost:8761

### Banco de Dados
Para acessar o PostgreSQL diretamente:
```bash
# Conectar ao banco
docker exec -it witcher-postgres psql -U witcher_user -d witcher_db

# Consultas úteis
SELECT COUNT(*) FROM items;
SELECT COUNT(*) FROM monsters;
SELECT COUNT(*) FROM contracts;
SELECT c.id, c.monster_id, c.status, c.created_at FROM contracts c;
```

## 🔧 Desenvolvimento Local

### Estrutura do Projeto
```
witcher-microservices/
├── api-gateway/                 # Gateway de entrada
├── auth-service/               # Serviço de autenticação
├── bestiary-and-armory-service/ # Serviço de itens e monstros
│   ├── item/                   # Módulo de itens
│   │   ├── dto/               # DTOs para itens
│   │   ├── mapper/            # Mapeadores de itens
│   │   ├── model/             # Entidades de itens
│   │   ├── repository/        # Repositórios de itens
│   │   └── service/           # Serviços de itens
│   ├── monster/               # Módulo de monstros
│   │   ├── dto/               # DTOs para monstros
│   │   ├── mapper/            # Mapeadores de monstros
│   │   ├── model/             # Entidades de monstros
│   │   ├── repository/        # Repositórios de monstros
│   │   └── service/           # Serviços de monstros
│   ├── controller/            # Controllers REST
│   ├── config/                # Configurações
│   └── security/              # Configurações de segurança
├── witcher-contracts-service/   # Serviço de contratos
├── service-discovery/          # Eureka Server
├── common-library/             # Biblioteca compartilhada
├── docker-compose.yml          # Orquestração dos serviços
├── Dockerfile.jvm             # Dockerfile para serviços Java
└── .env                       # Variáveis de ambiente
```

### Build Local
```bash
# Build de todos os módulos
mvn clean package -DskipTests

# Build de um módulo específico
mvn clean package -DskipTests -pl bestiary-and-armory-service -am
```

## 🐛 Troubleshooting

### Problemas Comuns

**1. Serviços não inicializam**
- Verifique se as portas não estão em uso
- Confirme se o Docker tem recursos suficientes
- Verifique os logs: `docker-compose logs <service-name>`

**2. Erro 403 nos endpoints protegidos**
- Confirme se o token JWT está válido
- Teste o endpoint `/api/auth/validate`
- Verifique se o token não expirou

**3. Erro 503 no Contracts Service**
- Confirme se o Bestiary Service está funcionando
- Verifique se o Feign Client está passando o token JWT
- Teste a comunicação direta entre serviços

**4. Swagger UI não carrega**
- Aguarde alguns minutos para inicialização completa
- Limpe o cache do navegador
- Tente acessar em aba anônima

## 🎮 Exemplos de Uso

### Cenário Completo: Do Registro ao Contrato

1. **Registrar como Bruxo**
2. **Fazer Login e obter token**
3. **Adicionar uma espada ao bestiário**
4. **Catalogar um monstro (ex: Grifo)**
5. **Criar um contrato que requer essa espada**
6. **Verificar se o contrato foi aceito**

Este fluxo simula um bruxo se registrando no sistema, catalogando monstros, adicionando equipamentos ao seu arsenal e aceitando um novo contrato.

### Exemplos de Endpoints

#### Gerenciamento de Itens
```bash
# Criar um item
curl -X POST http://localhost:8100/api/items \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Espada de Prata",
    "description": "Espada forjada especialmente para matar monstros",
    "itemType": "WEAPON",
    "price": 150.00
  }'

# Atualizar um item
curl -X PUT http://localhost:8100/api/items/1 \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Espada de Prata Aprimorada",
    "description": "Espada forjada e aprimorada para matar monstros",
    "itemType": "WEAPON",
    "price": 200.00
  }'
```

#### Gerenciamento de Monstros
```bash
# Criar um monstro
curl -X POST http://localhost:8100/api/monsters \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Grifo",
    "description": "Criatura híbrida com corpo de leão e cabeça de águia",
    "monsterType": "HYBRID",
    "weakness": "Bomba Aard, Óleo Anti-Híbrido",
    "habitat": "Montanhas e penhascos",
    "dangerLevel": 7
  }'

# Atualizar um monstro
curl -X PUT http://localhost:8100/api/monsters/1 \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Grifo Real",
    "description": "Versão mais poderosa do grifo comum",
    "monsterType": "HYBRID",
    "weakness": "Bomba Aard, Óleo Anti-Híbrido",
    "habitat": "Montanhas e penhascos",
    "dangerLevel": 9
  }'
```

#### Gerenciamento de Contratos
```bash
# Criar um contrato
curl -X POST http://localhost:8200/api/contracts \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "monsterId": 1,
    "requiredItemIds": [1, 2, 3]
  }'

# Atualizar status do contrato
curl -X PUT http://localhost:8200/api/contracts/1/status \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{
    "status": "ACCEPTED"
  }'

# Listar contratos por status
curl -X GET http://localhost:8200/api/contracts/status/PENDING \
  -H "Authorization: Bearer <token>"
```

## 🤝 Contribuindo

Contribuições são bem-vindas! Como diria Vesemir: *"Um bruxo sozinho é um bruxo morto"*. 

### Como Contribuir
1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📝 Licença

Este projeto é licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

## 🙏 Agradecimentos

Obrigado por explorar o **Witcher Microservices**! Este projeto foi desenvolvido com muito carinho e atenção aos detalhes, combinando as melhores práticas de arquitetura de microserviços com a rica mitologia do universo The Witcher.

### 💬 Feedback e Colaboração

Sua opinião é extremamente valiosa! Se você:

- 🐛 **Encontrou um bug**: Abra uma issue detalhando o problema
- 💡 **Tem uma ideia**: Compartilhe suas sugestões de melhorias
- 🚀 **Quer contribuir**: Faça um fork e envie seu pull request
- ⭐ **Gostou do projeto**: Deixe uma estrela no repositório
- 📢 **Quer compartilhar**: Conte para outros desenvolvedores

### 🌟 Próximos Passos

Este projeto está em constante evolução. Algumas funcionalidades planejadas:

- 🔍 Sistema de busca avançada no bestiário (itens e monstros)
- 📈 Dashboard de métricas e analytics
- 🌍 Suporte a múltiplas regiões (multi-tenant)
- 🔔 Sistema de notificações em tempo real
- 📱 API mobile-friendly
- 🎨 Upload de imagens para itens e monstros
- 📊 Relatórios de contratos por tipo de monstro

**Lembre-se**: *"O destino é tudo, Geralt."* - Mas com código bem escrito e arquitetura sólida, podemos moldar nosso próprio destino tecnológico! 

Que os bugs sejam poucos e os deploys sejam sempre bem-sucedidos! 🐺⚔️

---

*Desenvolvido com ❤️ por um bruxo apaixonado por tecnologia*