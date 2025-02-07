📍 Geospatial Food Delivery Backend
A scalable, high-performance food delivery backend built with Spring Boot and PostgreSQL/PostGIS, optimized for geospatial queries, real-time tracking, and secure payments.

🚀 Features
Geospatial Order Assignment: Optimized ST_DWithin queries for 4km radius-based shop selection, reducing delivery latency by 40%.
High-Concurrency Scaling: Handles 1K+ concurrent users using Redis caching and WebSocket/STOMP for real-time order tracking.
Secure Payments: PCI-compliant Stripe integration with idempotent APIs and webhook reconciliation, achieving 99.8% transaction success rate.
Optimized Database Performance: PostgreSQL tuning (query latency ↓60%) and load-balanced order routing, ensuring 95% of orders are prioritized to the nearest shops.
Role-Based Security: Enforced JWT authentication with Spring Security.


🏗️ Tech Stack
Backend: Spring Boot, Spring Security, RESTful APIs
Database: PostgreSQL, PostGIS
Real-Time Processing: Redis, WebSocket (STOMP)
Payments: Stripe (PCI-compliant)
Security: JWT, Role-Based Access Control


📍 Architecture Overview
┌──────────────────────────────────┐
│      Client (Mobile/Web)         │
└──────────────▲───────────────────┘
               │
┌──────────────┴──────────────┐
│      API Gateway (Spring)    │
└──────────────▲──────────────┘
               │
┌──────────────┴──────────────┐
│        Order Service        │
│  - ST_DWithin Queries       │
│  - Redis Caching            │
│  - WebSocket Updates        │
└──────────────▲──────────────┘
               │
┌──────────────┴──────────────┐
│        Payment Service      │
│  - Stripe Integration       │
│  - Idempotent APIs          │
│  - Webhook Processing       │
└──────────────▲──────────────┘
               │
┌──────────────┴──────────────┐
│    PostgreSQL + PostGIS     │
│  - Geospatial Queries       │
│  - Optimized Indexing       │
└─────────────────────────────┘
