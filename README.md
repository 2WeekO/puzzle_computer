## 조립 컴퓨터 전문 쇼핑몰 (개인 프로젝트)

기간:  24/04/01 ~  진행 중

### 프로젝트 명: 퍼즐컴 - 조립 컴퓨터 전문 쇼핑몰

### 프로젝트 개요

- 컴퓨터를 새로 구입하려고 하던 중 일반 컴퓨터 쇼핑몰에서 구입하는 것 보다 직접 부품을 하나 하나 구입하여 직접 조립하는 것이 저렴하여 사람들에게 컴퓨터를 보다 더욱 저렴하게 구입할 수 있도록 하여 조립 컴퓨터를 전문적으로 하는 쇼핑몰을 개발 및 운영하면 좋겠다고 생각하여 이러한 프로젝트를 시작하게 되었습니다.
- 이 프로젝트는 Java Spring Boot와 H2 데이터베이스를 기반으로 하며, 네이버 쇼핑 검색 API를 사용하여 현재까지는 실시간으로 제품의 정보를 확인할 수 있는 것까지 구현되어 있으며 이후 개인 쇼핑몰에서 구입까지 할 수 있는 것까지 목표로 하고 있습니다.

### 기술 스택

- **백엔드**: Java, Spring Boot, Spring Data JPA
- **프론트엔드**: HTML, CSS, JavaScript, Thymeleaf
- **데이터베이스**: H2 - console → (향후) MySQL 전환
- **API**: 네이버 쇼핑 API
- **기타 도구**: Git, Gradle

### 주요 기여 및 역할

- Back - end 개발
    - Spring Boot 사용 → RESTful API 설계 및 구현
    - H2 Database를 통해 제품 및 사용자 데이터 관리, JPA 활용 → DB 상호작용
    - 네이버 쇼핑 API 통합 → 실시간 제품 검색 및 정보 제공 기능 구현
    - 회원가입, 로그인 기능 구현
    - CRUD 기능 →  커뮤니티 게시판 구현
- Front - end 개발
    - HTML, CSS → 사용자 친화적인 UI 설계 및 구현
    - Thymeleaf 템플릿 엔진 사용 → 동적인 페이지 생성, 검색된 제품 목록 표시
- Database 설계 & 관리
    - H2 데이터베이스를 사용하여 개발 초기 단계에서 빠르게 프로토 타입을 제작할 수 있었고 이후 이를 기반으로 하여 MySQL 등으로 전환 예정 (유지 보수를 쉽게 하기 위해서)
    - Spring Data JPA 활용 → 데이터 베이스 스키마 자동 생성 및 유지

### 성과 및 결과

- **비동기적 UI 업데이트**
    - AJAX를 활용하여 사용자 인터페이스를 동적으로 업데이트함으로써 페이지 리로드 없이 사용자 경험을 개선했습니다.
- **사용자 맞춤형 기능**
    - 사용자 ID를 기반으로 장바구니 기능을 구현하여, 개별 사용자가 선택한 제품을 관리하고, 장바구니에 담긴 제품들의 총합을 실시간으로 계산하고 표시했습니다.
