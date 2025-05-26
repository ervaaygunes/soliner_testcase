# Dijital Kart Uygulaması

Freelancer'lar, yazılımcılar, tasarımcılar ve içerik üreticilerinin kişisel bilgilerini, projelerini ve dijital varlıklarını sergileyebilecekleri mobil uyumlu bir profil kartı uygulaması.

## 🚀 Teknolojiler

### Backend
- **Spring Boot 3.2.0** - REST API
- **Spring Security** - JWT Authentication
- **Spring Data JPA** - ORM
- **MySQL** - Veritabanı
- **Maven** - Dependency Management

### Frontend
- **React 18** - UI Framework
- **TailwindCSS** - Styling
- **Axios** - HTTP Client
- **Formik & Yup** - Form Validation
- **React Router** - Navigation
- **React Hot Toast** - Notifications

## 📋 Özellikler

- ✅ Kullanıcı kaydı/girişi (JWT Authentication)
- ✅ Profil kartı oluşturma ve düzenleme
- ✅ Proje ekleme ve yönetimi
- ✅ Sosyal medya linklerini yönetme
- ✅ Tema seçenekleri (Açık/Koyu)
- ✅ Mobil uyumlu tasarım
- ✅ Responsive tasarım

## 🛠️ Kurulum

### Gereksinimler
- Java 17+
- Node.js 16+
- MySQL 8.0+
- XAMPP (Opsiyonel)

### Backend Kurulumu

1. MySQL veritabanını başlatın (XAMPP veya standalone)
2. Backend dizinine gidin:
```bash
cd backend
```

3. Maven dependencies'i yükleyin:
```bash
mvn clean install
```

4. Uygulamayı çalıştırın:
```bash
mvn spring-boot:run
```

Backend http://localhost:8080 adresinde çalışacak.

### Frontend Kurulumu

1. Frontend dizinine gidin:
```bash
cd frontend
```

2. Dependencies'i yükleyin:
```bash
npm install
```

3. TailwindCSS'i build edin:
```bash
npx tailwindcss init -p
```

4. Uygulamayı başlatın:
```bash
npm start
```

Frontend http://localhost:3000 adresinde çalışacak.

## 🗄️ Veritabanı

Uygulama ilk çalıştırıldığında gerekli tablolar otomatik olarak oluşturulacak:

- `users` - Kullanıcı bilgileri
- `projects` - Proje bilgileri
- `social_links` - Sosyal medya linkleri

## 📱 API Endpoints

### Authentication
- `POST /api/auth/signup` - Kullanıcı kaydı
- `POST /api/auth/signin` - Kullanıcı girişi

### Users (Korumalı)
- `GET /api/users/profile` - Profil bilgilerini getir
- `PUT /api/users/profile` - Profil güncelle

### Projects (Korumalı)
- `GET /api/projects` - Projeleri listele
- `POST /api/projects` - Yeni proje ekle
- `PUT /api/projects/{id}` - Proje güncelle
- `DELETE /api/projects/{id}` - Proje sil

### Social Links (Korumalı)
- `GET /api/social-links` - Sosyal linkleri listele
- `POST /api/social-links` - Yeni link ekle
- `DELETE /api/social-links/{id}` - Link sil

## 🎨 Kullanım

1. Uygulamaya kayıt olun veya giriş yapın
2. Profil bilgilerinizi düzenleyin
3. Projelerinizi ekleyin
4. Sosyal medya linklerinizi ekleyin
5. Tema seçiminizi yapın
6. Profil kartınızı paylaşın

## 📸 Ekran Görüntüleri

- Login/Register sayfaları
- Dashboard
- Profil kartı
- Proje yönetimi
- Ayarlar

## 🚀 Gelecek Özellikler

- [ ] Avatar yükleme
- [ ] Proje resim yükleme
- [ ] Veri dışa aktarma (JSON/CSV)
- [ ] Profil görüntülenme sayacı
- [ ] Email ile profil paylaşımı
- [ ] QR kod oluşturma

## 👨‍💻 Geliştirici

Bu proje PRD dökümanındaki gereksinimlere göre geliştirilmiştir.

## 📄 Lisans

MIT License # soliner_testcase
