<div align="center">

![Header](https://capsule-render.vercel.app/api?type=waving&color=0:6366f1,100:8b5cf6&height=220&section=header&text=%E2%99%AA%20StreamMusic&fontSize=64&fontColor=ffffff&fontAlignY=38&desc=DDD%20%7C%20Strategy%20Pattern%20%7C%20SOLID&descAlignY=60&descSize=16&descColor=e0e7ff)
[![Typing SVG](https://readme-typing-svg.demolab.com?font=Fira+Code&weight=500&size=18&duration=3000&pause=800&color=6366F1&center=true&vCenter=true&random=false&width=650&lines=Plataforma+de+Streaming+de+Musica;Domain-Driven+Design+%7C+4+Bounded+Contexts;Strategy+Pattern+%7C+5+Regras+Antifraude;SOLID+%7C+Clean+Code+%7C+31+Testes+Passando)](https://git.io/typing-svg)

<a href="https://github.com/andrebecker84"><img src="doc/images/card-github.svg" height="48" alt="GitHub"></a>&nbsp;&nbsp;<a href="https://linkedin.com/in/becker84"><img src="doc/images/card-linkedin.svg" height="48" alt="LinkedIn"></a>

<img src="doc/images/card.svg" alt="StreamMusic project card"/>

</div>

---

## <img src="https://api.iconify.design/tabler/list-details.svg?color=%2394a3b8" height="18"> Índice

<a href="#-visão-geral"><kbd>&nbsp;01&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/layout-grid.svg?color=%2371a1fe" height="14"> &nbsp;<a href="#-visão-geral"><b>Visão Geral</b></a><br>
<a href="#-regras-de-antifraude--strategy-pattern"><kbd>&nbsp;02&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/shield-check.svg?color=%2371a1fe" height="14"> &nbsp;<a href="#-regras-de-antifraude--strategy-pattern"><b>Regras de Antifraude · Strategy Pattern</b></a><br>
<a href="#-arquitetura-ddd"><kbd>&nbsp;03&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/building-arch.svg?color=%2371a1fe" height="14"> &nbsp;<a href="#-arquitetura-ddd"><b>Arquitetura DDD</b></a><br>
<a href="#-design-patterns"><kbd>&nbsp;04&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/components.svg?color=%2371a1fe" height="14"> &nbsp;<a href="#-design-patterns"><b>Design Patterns</b></a><br>
<a href="#-camadas"><kbd>&nbsp;05&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/stack-2.svg?color=%2371a1fe" height="14"> &nbsp;<a href="#-camadas"><b>Camadas</b></a><br>
<a href="#-como-executar"><kbd>&nbsp;06&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/player-play.svg?color=%23a78bfa" height="14"> &nbsp;<a href="#-como-executar"><b>Como Executar</b></a><br>
<a href="#-frontend"><kbd>&nbsp;07&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/device-desktop.svg?color=%23a78bfa" height="14"> &nbsp;<a href="#-frontend"><b>Frontend</b></a><br>
<a href="#-api-rest"><kbd>&nbsp;08&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/api.svg?color=%23a78bfa" height="14"> &nbsp;<a href="#-api-rest"><b>API REST</b></a><br>
<a href="#-testes"><kbd>&nbsp;09&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="14"> &nbsp;<a href="#-testes"><b>Testes</b></a><br>
<a href="#-clientes-http"><kbd>&nbsp;10&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/plug-connected.svg?color=%23ffc05c" height="14"> &nbsp;<a href="#-clientes-http"><b>Clientes HTTP</b></a><br>
<a href="#-estrutura"><kbd>&nbsp;11&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/folder-open.svg?color=%23ffc05c" height="14"> &nbsp;<a href="#-estrutura"><b>Estrutura de Pastas</b></a><br>
<a href="#-relatório-técnico"><kbd>&nbsp;12&nbsp;</kbd></a> &nbsp;<img src="https://api.iconify.design/tabler/book-2.svg?color=%23ffc05c" height="14"> &nbsp;<a href="#-relatório-técnico"><b>Relatório Técnico</b></a>

---

## <img src="https://api.iconify.design/tabler/layout-grid.svg?color=%2371a1fe" height="18"> Visão Geral

<div align="center">

[![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)](https://openjdk.org)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.0-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.16-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org)
[![H2](https://img.shields.io/badge/H2-Database-003399?logo=h2database&logoColor=white)](https://h2database.com)
[![Redis](https://img.shields.io/badge/Redis-Cache-DC382D?logo=redis&logoColor=white)](https://redis.io)
[![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?logo=docker&logoColor=white)](https://docker.com)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.38-CC0000?logo=java&logoColor=white)](https://projectlombok.org)

</div>

<p align="center">
  <img src="doc/images/visao-geral.svg" alt="Visão Geral"/>
</p>

---

## <img src="https://api.iconify.design/tabler/shield-check.svg?color=%2371a1fe" height="18"> Regras de Antifraude — Strategy Pattern

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr>
  <th align="center" width="36%">Código de Violação</th>
  <th align="center" width="44%">Condição de Rejeição</th>
  <th align="center" width="24%">Classe Strategy</th>
</tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr>
  <td><code>cartão-de-crédito-inválido</code></td>
  <td>Conta sem cartão cadastrado</td>
  <td><img src="https://img.shields.io/badge/RegraCartaoValido-475569?style=plastic" /></td>
</tr>
<tr>
  <td><code>cartão-não-ativo</code></td>
  <td>Cartão existe mas está inativo</td>
  <td><img src="https://img.shields.io/badge/RegraCartaoAtivo-475569?style=plastic" /></td>
</tr>
<tr>
  <td><code>plano-ativo-inválido</code></td>
  <td>Sem assinatura ativa</td>
  <td><img src="https://img.shields.io/badge/RegraAssinaturaAtiva-475569?style=plastic" /></td>
</tr>
<tr>
  <td><code>alta-frequência-pequeno-intervalo</code></td>
  <td>Mais de <b>3</b> transações em <b>2 min</b></td>
  <td><img src="https://img.shields.io/badge/RegraAltaFrequenciaPequenoIntervalo-475569?style=plastic" /></td>
</tr>
<tr>
  <td><code>transação-duplicada</code></td>
  <td>Mesmo valor + comércio, <b>2×+</b> em <b>2 min</b></td>
  <td><img src="https://img.shields.io/badge/RegraTransacaoDuplicada-475569?style=plastic" /></td>
</tr>
</tbody>
</table>

> <img src="https://api.iconify.design/tabler/bulb.svg?color=%23ffc05c" height="14"> **OCP em ação:** adicionar nova regra = criar `@Component implements RegraAntifraude`. O `ServicoAntifraude` nunca é modificado.

<div style="background:#0d1117;border:1px solid #30363d;border-radius:8px;padding:4px 0;margin:8px 0;">

```mermaid
%%{init: {'theme': 'dark', 'themeVariables': {'primaryColor': '#1e2035', 'primaryTextColor': '#e2e8f0', 'primaryBorderColor': '#6366f1', 'lineColor': '#818cf8', 'mainBkg': '#1e2035', 'nodeBorder': '#6366f1', 'background': '#0f1117'}}}%%
classDiagram
    class RegraAntifraude {
        <<interface>>
        +validar(FraudValidationContext) Optional~FraudViolation~
    }
    class ServicoAntifraude {
        -List~RegraAntifraude~ regras
        +validar(FraudValidationContext) List~FraudViolation~
    }
    class RegraCartaoValido["RegraCartaoValido ＠Order(1)"]
    class RegraCartaoAtivo["RegraCartaoAtivo ＠Order(2)"]
    class RegraAssinaturaAtiva["RegraAssinaturaAtiva ＠Order(3)"]
    class RegraAltaFrequenciaPequenoIntervalo["RegraAltaFrequenciaPequenoIntervalo ＠Order(4)"]
    class RegraTransacaoDuplicada["RegraTransacaoDuplicada ＠Order(5)"]

    ServicoAntifraude o-- RegraAntifraude : injeta lista
    RegraAntifraude <|.. RegraCartaoValido
    RegraAntifraude <|.. RegraCartaoAtivo
    RegraAntifraude <|.. RegraAssinaturaAtiva
    RegraAntifraude <|.. RegraAltaFrequenciaPequenoIntervalo
    RegraAntifraude <|.. RegraTransacaoDuplicada
```

</div>

**Exemplo de resposta rejeitada:**
```json
{ "aprovada": false, "violacoes": ["cartão-não-ativo", "plano-ativo-inválido"] }
```

---

## <img src="https://api.iconify.design/tabler/building-arch.svg?color=%2371a1fe" height="18"> Arquitetura DDD

### Mapa de Contextos

<div style="background:#0d1117;border:1px solid #30363d;border-radius:8px;padding:4px 0;margin:8px 0;">

```mermaid
%%{init: {'theme': 'dark', 'themeVariables': {'primaryColor': '#1a1d2e', 'primaryTextColor': '#e2e8f0', 'primaryBorderColor': '#4a5568', 'lineColor': '#818cf8', 'edgeLabelBackground': '#0d1117', 'clusterBkg': '#0d1117', 'clusterBorder': '#4a5568', 'background': '#0d1117', 'mainBkg': '#1a1d2e', 'nodeBorder': '#4a5568'}}}%%
graph TB
    subgraph C1 ["◆ Conta — Core Domain"]
        ACC["Account\nCreditCard (VO)"]
    end
    subgraph C2 ["◆ Assinatura — Supporting Domain"]
        SUB["Subscription\nPlanType (VO)"]
    end
    subgraph C3 ["◆ Música — Core Domain"]
        MUS["Song · Playlist\nMusicaFavorita"]
    end
    subgraph C4 ["◆ Transação + Antifraude — Generic Domain"]
        TRX["Transaction\nMoney VO · Merchant VO"]
        FRAUD["ServicoAntifraude\n5 × RegraAntifraude"]
    end
    SUB -->|"Customer-Supplier · accountId"| ACC
    TRX -->|"Customer-Supplier · accountId"| ACC
    TRX -->|"Customer-Supplier · accountId"| SUB
    MUS -->|"Customer-Supplier · accountId"| ACC
    FRAUD -.->|"Anticorruption Layer\nFraudValidationContext"| TRX
    style C1 fill:#0a1428,stroke:#71a1fe,color:#71a1fe
    style C2 fill:#120a28,stroke:#a78bfa,color:#a78bfa
    style C3 fill:#0a1428,stroke:#71a1fe,color:#71a1fe
    style C4 fill:#1c0f08,stroke:#fb923c,color:#fb923c
```

</div>

> Integração **por referência de UUID** — contextos desacoplados, sem dependência direta entre entidades.


### Aggregates & Value Objects

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th>Aggregate Root</th><th>Value Objects / Filhos</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><code>Account</code></td><td><code>CreditCard</code> (VO — @Embeddable): number · active · limit</td></tr>
<tr><td><code>Subscription</code></td><td><code>PlanType</code> (Enum VO): BASICO · PREMIUM · FAMILIA</td></tr>
<tr><td><code>Transaction</code></td><td><code>Money</code> (VO) · <code>Merchant</code> (VO)</td></tr>
<tr><td><code>Playlist</code></td><td><code>List&lt;Song&gt;</code> (ManyToMany)</td></tr>
<tr><td><code>MusicaFavorita</code></td><td><code>Song</code> (Entity — catálogo compartilhado)</td></tr>
</tbody>
</table>

---

## <img src="https://api.iconify.design/tabler/components.svg?color=%2371a1fe" height="18"> Design Patterns

<p align="center">
  <img src="doc/images/design-patterns.svg" alt="Design Patterns"/>
</p>

---

## <img src="https://api.iconify.design/tabler/stack-2.svg?color=%2371a1fe" height="18"> Camadas

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th width="22%">Camada</th><th width="30%">Pacote</th><th width="48%">Responsabilidade</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://api.iconify.design/tabler/world.svg?color=%23a78bfa" height="14"> Controller</td><td><code>interfaces/rest/</code></td><td>Recebe HTTP · delega ao Application Service</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/file-export.svg?color=%23a78bfa" height="14"> DTO</td><td><code>interfaces/dto/</code></td><td>Contratos de entrada/saída — nunca expõe entidades de domínio</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/settings.svg?color=%2371a1fe" height="14"> Application Service</td><td><code>application/*/</code></td><td>Orquestra domínio · sem lógica de negócio</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/circle-dot.svg?color=%23c084fc" height="14"> Aggregate / Entity</td><td><code>domain/*/</code></td><td>Lógica de negócio · invariantes · estado</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/diamond.svg?color=%2334d399" height="14"> Value Object</td><td><code>domain/*/</code></td><td>Imutável · sem identidade própria · igualdade por valor</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/code.svg?color=%2371a1fe" height="14"> Repository (interface)</td><td><code>domain/*/</code></td><td>Contrato definido pelo domínio</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/database.svg?color=%2360a5fa" height="14"> Repository (JPA)</td><td><code>infrastructure/persistence/</code></td><td>Implementação Spring Data JPA</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/repeat.svg?color=%2371a1fe" height="14"> Strategy</td><td><code>domain/transaction/fraud/</code></td><td>Interface + 5 regras <code>@Component @Order</code></td></tr>
</tbody>
</table>

> <img src="https://api.iconify.design/tabler/alert-triangle.svg?color=%23ffc05c" height="14"> `domain/` nunca importa de `infrastructure/` ou `interfaces/`. Dependências apontam sempre para dentro.

---

## <img src="https://api.iconify.design/tabler/player-play.svg?color=%23a78bfa" height="18"> Como Executar

<p align="center">
  <img src="doc/images/como-executar.svg" alt="Como Executar"/>
</p>

### <img src="https://api.iconify.design/tabler/link.svg?color=%23a78bfa" height="16"> URLs

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th width="38%">URL</th><th width="62%">Descrição</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><a href="http://localhost:8087"><kbd>http://localhost:8087</kbd></a></td><td><img src="https://api.iconify.design/tabler/world.svg?color=%23a78bfa" height="14"> Interface web dark-theme</td></tr>
<tr><td><a href="http://localhost:8087/swagger-ui.html"><kbd>http://localhost:8087/swagger-ui.html</kbd></a></td><td><img src="https://api.iconify.design/tabler/book.svg?color=%23a78bfa" height="14"> Swagger UI — explorar e testar a API</td></tr>
<tr><td><a href="http://localhost:8087/h2-console"><kbd>http://localhost:8087/h2-console</kbd></a></td><td><img src="https://api.iconify.design/tabler/database.svg?color=%2371a1fe" height="14"> Console H2 — JDBC: <code>jdbc:h2:mem:streaming</code> · user: <code>sa</code> · sem senha</td></tr>
<tr><td><a href="http://localhost:8087/api-docs"><kbd>http://localhost:8087/api-docs</kbd></a></td><td><img src="https://api.iconify.design/tabler/file-description.svg?color=%23a78bfa" height="14"> OpenAPI JSON</td></tr>
<tr><td><a href="http://localhost:8081"><kbd>http://localhost:8081</kbd></a></td><td><img src="https://api.iconify.design/tabler/server.svg?color=%23f87171" height="14"> Redis Commander <em>(somente Docker)</em></td></tr>
</tbody>
</table>

### <img src="https://api.iconify.design/tabler/users.svg?color=%2371a1fe" height="16"> Contas Demo

Criadas automaticamente ao iniciar — prontas para testar os cenários de antifraude:

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th width="15%">Conta</th><th width="22%">Número do Cartão</th><th width="10%" align="center">Cartão</th><th width="10%">Plano</th><th width="43%">Cenário de Teste</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://api.iconify.design/tabler/user.svg?color=%2371a1fe" height="14"> João Silva</td><td><code>4111-1111-1111-1111</code></td><td align="center"><img src="https://img.shields.io/badge/ATIVO-49cc90"/></td><td align="center" style="white-space:nowrap"><kbd><img src="https://api.iconify.design/tabler/crown.svg?color=%23fbbf24" height="13"> PREMIUM</kbd></td><td>Transações aprovadas · 4 favoritos · playlist <em>Lo-Fi Essentials</em></td></tr>
<tr><td><img src="https://api.iconify.design/tabler/user.svg?color=%2371a1fe" height="14"> Maria Oliveira</td><td><code>5500-0000-0000-0004</code></td><td align="center"><img src="https://img.shields.io/badge/ATIVO-49cc90"/></td><td align="center" style="white-space:nowrap"><kbd><img src="https://api.iconify.design/tabler/music.svg?color=%2360a5fa" height="13"> BÁSICO</kbd></td><td>Testar limite de frequência</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/user.svg?color=%2371a1fe" height="14"> Pedro Santos</td><td><code>3714-496353-98431</code></td><td align="center"><img src="https://img.shields.io/badge/INATIVO-f93e3e"/></td><td align="center" style="white-space:nowrap"><kbd><img src="https://api.iconify.design/tabler/ban.svg?color=%234a5568" height="13"> sem plano</kbd></td><td><code>cartão-não-ativo</code> + <code>plano-ativo-inválido</code></td></tr>
</tbody>
</table>

---

## <img src="https://api.iconify.design/tabler/device-desktop.svg?color=%23a78bfa" height="18"> Frontend

<kbd>http://localhost:8087</kbd> — SPA dark-theme embutida no artefato Spring Boot (sem frameworks JS separados)

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th>Aba</th><th>Funcionalidades</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="14"> Músicas</td><td>Catálogo completo · copiar ID para clipboard</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/user.svg?color=%23a78bfa" height="14"> Conta</td><td>Criar · buscar por ID</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/clipboard-list.svg?color=%23a78bfa" height="14"> Assinatura</td><td>Assinar · consultar · cancelar plano</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/credit-card.svg?color=%23a78bfa" height="14"> Transação</td><td>Autorizar · feedback visual de violações antifraude</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/heart.svg?color=%23f87171" height="14"> Favoritos</td><td>Favoritar · listar músicas preferidas</td></tr>
<tr><td><img src="https://api.iconify.design/tabler/headphones.svg?color=%23a78bfa" height="14"> Playlists</td><td>Criar playlist · adicionar músicas</td></tr>
</tbody>
</table>

---

## <img src="https://api.iconify.design/tabler/api.svg?color=%23a78bfa" height="18"> API REST

### <img src="https://api.iconify.design/tabler/user.svg?color=%23a78bfa" height="16"> Contas

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th>Método</th><th>Endpoint</th><th>Ação</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://img.shields.io/badge/POST-49cc90"/></td><td><code>/api/contas</code></td><td>Criar conta</td></tr>
<tr><td><img src="https://img.shields.io/badge/GET-61affe"/></td><td><code>/api/contas</code></td><td>Listar todas as contas</td></tr>
<tr><td><img src="https://img.shields.io/badge/GET-61affe"/></td><td><code>/api/contas/{id}</code></td><td>Buscar conta por ID</td></tr>
</tbody>
</table>

### <img src="https://api.iconify.design/tabler/clipboard-list.svg?color=%23a78bfa" height="16"> Assinaturas

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th>Método</th><th>Endpoint</th><th>Ação</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://img.shields.io/badge/POST-49cc90"/></td><td><code>/api/assinaturas</code></td><td>Assinar plano</td></tr>
<tr><td><img src="https://img.shields.io/badge/GET-61affe"/></td><td><code>/api/assinaturas/contas/{id}/ativa</code></td><td>Buscar assinatura ativa</td></tr>
<tr><td><img src="https://img.shields.io/badge/DELETE-f93e3e"/></td><td><code>/api/assinaturas/contas/{id}</code></td><td>Cancelar assinatura</td></tr>
</tbody>
</table>

### <img src="https://api.iconify.design/tabler/credit-card.svg?color=%23a78bfa" height="16"> Transações

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th>Método</th><th>Endpoint</th><th>Ação</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://img.shields.io/badge/POST-49cc90"/></td><td><code>/api/transacoes/autorizar</code></td><td>Autorizar com antifraude</td></tr>
</tbody>
</table>

### <img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="16"> Músicas, Favoritos e Playlists

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr><th>Método</th><th>Endpoint</th><th>Ação</th></tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr><td><img src="https://img.shields.io/badge/GET-61affe"/></td><td><code>/api/musicas</code></td><td>Catálogo (cacheado Redis)</td></tr>
<tr><td><img src="https://img.shields.io/badge/POST-49cc90"/></td><td><code>/api/contas/{id}/favoritos</code></td><td>Favoritar música</td></tr>
<tr><td><img src="https://img.shields.io/badge/GET-61affe"/></td><td><code>/api/contas/{id}/favoritos</code></td><td>Listar favoritos</td></tr>
<tr><td><img src="https://img.shields.io/badge/DELETE-f93e3e"/></td><td><code>/api/contas/{id}/favoritos/{musicaId}</code></td><td>Remover favorito</td></tr>
<tr><td><img src="https://img.shields.io/badge/POST-49cc90"/></td><td><code>/api/contas/{id}/playlists</code></td><td>Criar playlist</td></tr>
<tr><td><img src="https://img.shields.io/badge/GET-61affe"/></td><td><code>/api/contas/{id}/playlists</code></td><td>Listar playlists</td></tr>
<tr><td><img src="https://img.shields.io/badge/POST-49cc90"/></td><td><code>/api/playlists/{id}/musicas</code></td><td>Adicionar música</td></tr>
<tr><td><img src="https://img.shields.io/badge/DELETE-f93e3e"/></td><td><code>/api/contas/{id}/playlists/{pId}/musicas/{mId}</code></td><td>Remover música</td></tr>
</tbody>
</table>

<details>
<summary><img src="https://api.iconify.design/tabler/terminal.svg?color=%23a78bfa" height="14"> Exemplos cURL</summary>

```bash
# Criar conta
curl -X POST http://localhost:8087/api/contas \
  -H "Content-Type: application/json" \
  -d '{"nome":"João","email":"joao@ex.com","numeroCartao":"4111","cartaoAtivo":true,"limiteCartao":5000}'

# Assinar plano
curl -X POST http://localhost:8087/api/assinaturas \
  -H "Content-Type: application/json" \
  -d '{"contaId":"<UUID>","tipoPlano":"PREMIUM"}'

# Autorizar transação
curl -X POST http://localhost:8087/api/transacoes/autorizar \
  -H "Content-Type: application/json" \
  -d '{"contaId":"<UUID>","valor":99.90,"nomeComercio":"StreamStore"}'
```

</details>

---

## <img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="18"> Testes

<div align="center">

[![Status](https://img.shields.io/badge/Status-Completo-success?logo=checkmarx&logoColor=white)](https://github.com/andrebecker84)
[![Testes](https://img.shields.io/badge/Testes-31_passing-brightgreen?logo=junit5&logoColor=white)](https://github.com/andrebecker84)
[![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?logo=junit5&logoColor=white)](https://junit.org/junit5)
[![Mockito](https://img.shields.io/badge/Mockito-Mock_Framework-78C257?logo=java&logoColor=white)](https://site.mockito.org)
[![AAA](https://img.shields.io/badge/Testes-AAA_Pattern-blue?logo=testcafe&logoColor=white)](https://github.com/andrebecker84)

</div>

<table style="background:#0d1117;border:1px solid #30363d;border-radius:8px;border-collapse:separate;font-family:monospace;font-size:13px;margin:4px 0;">
<tr><td style="border:0;padding:8px 16px;"><span style="color:#4b5563;">$</span> <span style="color:#c5f989;">mvn test</span></td></tr>
</table>

Metodologia **AAA (Arrange / Act / Assert)** — `// Act & Assert` somente em `assertThatThrownBy`, onde Act e Assert são inseparáveis por natureza.

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
<tr>
  <th align="center" width="34%">Classe de Teste</th>
  <th align="center" width="22%">Tipo</th>
  <th align="center" width="36%">Cobertura</th>
  <th align="center" width="8%">#</th>
</tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr>
  <td><code>RegraCartaoAtivoTest</code></td>
  <td><img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="14"> Unitário · domínio</td>
  <td>Cartão inativo/ausente → violação correta</td>
  <td align="center"><kbd style="color:#c5f989">3</kbd></td>
</tr>
<tr>
  <td><code>RegraCartaoValidoTest</code></td>
  <td><img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="14"> Unitário · domínio</td>
  <td>Conta sem cartão → <code>cartão-de-crédito-inválido</code></td>
  <td align="center"><kbd style="color:#c5f989">2</kbd></td>
</tr>
<tr>
  <td><code>RegraAltaFrequenciaTest</code></td>
  <td><img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="14"> Unitário · domínio</td>
  <td>Janela de 2 min · limite de 3 TRX</td>
  <td align="center"><kbd style="color:#c5f989">2</kbd></td>
</tr>
<tr>
  <td><code>RegraTransacaoDuplicadaTest</code></td>
  <td><img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="14"> Unitário · domínio</td>
  <td>Limite de 2 transações semelhantes</td>
  <td align="center"><kbd style="color:#c5f989">2</kbd></td>
</tr>
<tr>
  <td><code>TransactionTest</code></td>
  <td><img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="14"> Unitário · domínio</td>
  <td><code>isSimilarTo</code> — valor + comerciante</td>
  <td align="center"><kbd style="color:#c5f989">3</kbd></td>
</tr>
<tr>
  <td><code>AssinaturaApplicationServiceTest</code></td>
  <td><img src="https://api.iconify.design/tabler/puzzle.svg?color=%23c5f989" height="14"> Mockito</td>
  <td>Assinar · cancelar · validar plano único</td>
  <td align="center"><kbd style="color:#c5f989">5</kbd></td>
</tr>
<tr>
  <td><code>TransacaoApplicationServiceTest</code></td>
  <td><img src="https://api.iconify.design/tabler/puzzle.svg?color=%23c5f989" height="14"> Mockito</td>
  <td>Fluxo completo de autorização + fraude</td>
  <td align="center"><kbd style="color:#c5f989">5</kbd></td>
</tr>
<tr>
  <td><code>ContaControllerTest</code></td>
  <td><img src="https://api.iconify.design/tabler/world.svg?color=%23c5f989" height="14"> MockMvc</td>
  <td>HTTP · serialização · status codes</td>
  <td align="center"><kbd style="color:#c5f989">5</kbd></td>
</tr>
<tr>
  <td><code>TransacaoControllerTest</code></td>
  <td><img src="https://api.iconify.design/tabler/world.svg?color=%23c5f989" height="14"> MockMvc</td>
  <td>Aprovação · rejeição · violações JSON</td>
  <td align="center"><kbd style="color:#c5f989">4</kbd></td>
</tr>
<tr>
  <td colspan="3" align="right"><b>Total</b></td>
  <td align="center"><img src="https://img.shields.io/badge/31-✔-25A162?style=plastic" /></td>
</tr>
</tbody>
</table>

---

## <img src="https://api.iconify.design/tabler/plug-connected.svg?color=%23ffc05c" height="18"> Clientes HTTP

<table width="760" style="border-radius: 10px;">
<thead style="background-color: #0d1117;">
    <tr>
        <th align="center" width="50%"><img src="https://img.shields.io/badge/IntelliJ-HTTP Client-purple?logo=jetbrains" alt="IntelliJ HTTP Client"/></th>
        <th align="center" width="50%"><img src="https://img.shields.io/badge/Bruno-API_Client-EF8C2A?logo=bruno" alt="Bruno"/></th>
    </tr>
</thead>
<tbody style="background-color: #1a1d2e;">
<tr>
<td valign="top">
<kbd><img src="https://api.iconify.design/tabler/folder.svg?color=%23ffc05c" height="13"> http/</kbd>
<ol>
    <li>Abra qualquer arquivo <code>.http</code> no IntelliJ IDEA</li>
    <li>Selecione o ambiente <b>local</b> no dropdown (↗ canto superior)</li>
    <li>Execute os arquivos <b>em ordem numérica</b></li>
</ol>

>`contaId` propagado automaticamente via variáveis `@no.env`

<b>Sequência recomendada:</b>
<div style="box-sizing:border-box;background:#0d1117;border:1px solid #1e293b;border-radius:6px;padding:10px 14px;margin-top:6px;font-family:monospace;font-size:12px;line-height:1.7;">
<div style="display:flex;gap:8px;"><span style="width:205px;flex-shrink:0;">01_criar-conta.http</span><span>→ <img src="https://api.iconify.design/tabler/key.svg?color=%23ffc05c" height="13"> salva contaId</span></div>
<div style="display:flex;gap:8px;"><span style="width:205px;flex-shrink:0;">02_assinatura.http</span><span>→ <img src="https://api.iconify.design/tabler/clipboard-list.svg?color=%23a78bfa" height="13"> assina plano PREMIUM</span></div>
<div style="display:flex;gap:8px;"><span style="width:205px;flex-shrink:0;">03_listar-musicas.http</span><span>→ <img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="13"> exibe catálogo</span></div>
<div style="display:flex;gap:8px;"><span style="width:205px;flex-shrink:0;">04_favoritar.http</span><span>→ <img src="https://api.iconify.design/tabler/heart.svg?color=%23f87171" height="13"> favorita música</span></div>
<div style="display:flex;gap:8px;"><span style="width:205px;flex-shrink:0;">05_playlist.http</span><span>→ <img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="13"> cria playlist</span></div>
<div style="display:flex;gap:8px;"><span style="width:205px;flex-shrink:0;">06_transacao.http</span><span>→ <img src="https://api.iconify.design/tabler/credit-card.svg?color=%23a78bfa" height="13"> análise antifraude</span></div>
</div>
</td>
<td valign="top">
<kbd><img src="https://api.iconify.design/tabler/folder.svg?color=%23ffc05c" height="13"> bruno/</kbd>
<ol>
<li>No Bruno: <b>Open Collection</b> → selecione a pasta <code>bruno/</code></li>
<li>Selecione o ambiente <b>local</b> em <code>environments/local.bru</code></li>
<li>Execute as requests <b>na ordem das pastas</b></li>
</ol>

>`contaId` e `musicaId` salvos automaticamente via `script:post-response`

<b>Sequência recomendada:</b>
<div style="box-sizing:border-box;background:#0d1117;border:1px solid #1e293b;border-radius:6px;padding:10px 14px;margin-top:6px;font-family:monospace;font-size:12px;line-height:1.7;">
<div style="display:flex;gap:8px;"><span style="width:230px;flex-shrink:0;">1. Conta / Criar Conta</span><span>→ <img src="https://api.iconify.design/tabler/key.svg?color=%23ffc05c" height="13"> salva contaId</span></div>
<div style="display:flex;gap:8px;"><span style="width:230px;flex-shrink:0;">2. Assinatura / Assinar Plano</span><span>→ <img src="https://api.iconify.design/tabler/clipboard-list.svg?color=%23a78bfa" height="13"> assina plano PREMIUM</span></div>
<div style="display:flex;gap:8px;"><span style="width:230px;flex-shrink:0;">3. Musica / Listar Músicas</span><span>→ <img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="13"> exibe catálogo</span></div>
<div style="display:flex;gap:8px;"><span style="width:230px;flex-shrink:0;">4. Musica / Favoritar</span><span>→ <img src="https://api.iconify.design/tabler/heart.svg?color=%23f87171" height="13"> favorita música</span></div>
<div style="display:flex;gap:8px;"><span style="width:230px;flex-shrink:0;">5. Playlist / Criar Playlist</span><span>→ <img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="13"> cria playlist</span></div>
<div style="display:flex;gap:8px;"><span style="width:230px;flex-shrink:0;">6. Transacao / Autorizar</span><span>→ <img src="https://api.iconify.design/tabler/credit-card.svg?color=%23a78bfa" height="13"> análise antifraude</span></div>
</div>
</td>
</tr>
</tbody>
</table>

---

## <img src="https://api.iconify.design/tabler/folder-open.svg?color=%23ffc05c" height="18"> Estrutura

<details>
<summary><img src="https://api.iconify.design/tabler/folder-open.svg?color=%23ffc05c" height="13"> Ver árvore completa de pacotes</summary>

<table style="background:#0d1117;border:1px solid #30363d;border-radius:8px;border-collapse:collapse;width:100%;font-family:monospace;font-size:12px;line-height:1.3;margin-top:8px;">
<tbody style="border:0;">
<tr style="border:0;"><td style="border:0;padding:5px 8px 2px 8px;white-space:nowrap;color:#c9d1d9;"><img src="https://api.iconify.design/tabler/archive.svg?color=%2371a1fe" height="13"> <b>StreamMusic</b></td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;"></td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> src/main/java/…/musica</td><td style="border:0;"></td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> <b>domain</b></td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Núcleo puro — zero dependências externas</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> account</td><td style="border:0;padding:1px 8px;color:#71a1fe;font-size:11px;"><img src="https://api.iconify.design/tabler/home.svg?color=%2371a1fe" height="12"> Conta (Core Domain)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/circle-dot.svg?color=%23c084fc" height="13"> Account.java</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Aggregate Root</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/diamond.svg?color=%2334d399" height="13"> CreditCard.java</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Value Object (@Embeddable)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;└─&nbsp;</span><img src="https://api.iconify.design/tabler/code.svg?color=%2371a1fe" height="13"> AccountRepository.java</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Interface de repositório</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> subscription</td><td style="border:0;padding:1px 8px;color:#a78bfa;font-size:11px;"><img src="https://api.iconify.design/tabler/clipboard-list.svg?color=%23a78bfa" height="12"> Assinatura (Supporting Domain)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> transaction</td><td style="border:0;padding:1px 8px;color:#a78bfa;font-size:11px;"><img src="https://api.iconify.design/tabler/credit-card.svg?color=%23a78bfa" height="12"> Transação (Generic Domain)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;└─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> fraud</td><td style="border:0;padding:1px 8px;color:#71a1fe;font-size:11px;"><img src="https://api.iconify.design/tabler/shield-check.svg?color=%2371a1fe" height="12"> Antifraude — Strategy Pattern</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/code.svg?color=%2371a1fe" height="13"> RegraAntifraude.java</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Interface Strategy</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/settings-2.svg?color=%23fb923c" height="13"> ServicoAntifraude.java</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Domain Service</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─&nbsp;</span><img src="https://api.iconify.design/tabler/shield-check.svg?color=%2371a1fe" height="13"> Regra*.java × 5</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Implementações @Component @Order</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;│&nbsp;&nbsp;└─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> music</td><td style="border:0;padding:1px 8px;color:#a78bfa;font-size:11px;"><img src="https://api.iconify.design/tabler/music.svg?color=%23a78bfa" height="12"> Música (Core Domain)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> <b>application</b></td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Casos de uso — Commands + Services</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> <b>infrastructure</b></td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">JPA · Redis · Config · DataInitializer</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;└─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> <b>interfaces/rest</b></td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Controllers REST · DTOs</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%2371a1fe" height="13"> src/main/resources</td><td style="border:0;"></td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/settings.svg?color=%2394a3b8" height="13"> application.properties</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Porta 8087 · cache simple/redis</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;├─&nbsp;</span><img src="https://api.iconify.design/tabler/database.svg?color=%2360a5fa" height="13"> data.sql</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">12 músicas seed (catálogo lo-fi CC)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">│&nbsp;&nbsp;└─&nbsp;</span><img src="https://api.iconify.design/tabler/code.svg?color=%23fb923c" height="13"> static/index.html</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">SPA dark-theme</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%23c5f989" height="13"> <b>src/test</b></td><td style="border:0;padding:1px 8px;color:#c5f989;font-size:11px;"><img src="https://api.iconify.design/tabler/test-pipe.svg?color=%23c5f989" height="12"> 31 testes — JUnit 5 · Mockito · MockMvc</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%23ffc05c" height="13"> http</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">IntelliJ HTTP Client (6 arquivos .http)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/folder.svg?color=%23ffc05c" height="13"> bruno</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Bruno Collection (16 arquivos .bru)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/book-2.svg?color=%23ffc05c" height="13"> doc/RELATORIO_AT.md</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Relatório técnico completo</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">├─&nbsp;</span><img src="https://api.iconify.design/tabler/brand-docker.svg?color=%2338bdf8" height="13"> Dockerfile</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Multi-stage build (Maven → JRE Alpine)</td></tr>
<tr style="border:0;"><td style="border:0;padding:1px 8px 5px 8px;white-space:nowrap;color:#c9d1d9;"><span style="color:#3d4451">└─&nbsp;</span><img src="https://api.iconify.design/tabler/brand-docker.svg?color=%2338bdf8" height="13"> docker-compose.yml</td><td style="border:0;padding:1px 8px;color:#4a5568;font-size:11px;">Redis · App · Redis Commander</td></tr>
</tbody>
</table>

</details>

---

## <img src="https://api.iconify.design/tabler/book-2.svg?color=%23ffc05c" height="18"> Relatório Técnico

<div align="center">
<a href="doc/RELATORIO_AT.md"><img src="https://img.shields.io/badge/DOC/RELATORIO__AT.md-white?style=for-the-badge&amp;logo=googledocs&amp" alt="RELATORIO_AT.md"></a>&nbsp;&nbsp;
<a href="LICENSE"><img src="https://img.shields.io/badge/✔_License-MIT-gold?style=for-the-badge" alt="License MIT"></a>
</div>

> Justificativas completas sobre Design Patterns, SOLID, DDD estratégico/tático, Aggregates, Context Map e Domínio Rico.
Inclui as **referências bibliográficas** completas (Evans, Martin, Gamma/GoF, Vernon).

---

<div align="center">

<img src="doc/images/author2.svg" width="520" alt="StreamMusic — André Becker"/>

[![Disciplina](https://img.shields.io/badge/Engenharia_de_Software-Design_Patterns_%26_DDD_(DR2)-7c5cbf?style=for-the-badge)](https://www.infnet.edu.br)
![Footer](https://capsule-render.vercel.app/api?type=waving&color=0:6366f1,100:8b5cf6&height=120&section=footer)
</div>
