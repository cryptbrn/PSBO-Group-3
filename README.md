# Pengembangan Sistem Berorientasi Objek
## Praktikum
Kelompok 3
| No | Nama                     | NIM       |
| -- | -------------------------| ----------|
| 1  | Alvina Maharani Hasibuan | G64190004 |
| 2  | Linuz Tri Erianto        | G64190027 |
| 3  | Abdul Hakim              | G64190078 |
| 4  | Muhammad Reyhan          | G64190083 |
| 5  | Maxdha Maxiwinata        | G64190105 |

# Random User Generator

# A. Product Vision
## 1. Problem Description
Saat ini banyak frontend developer kesulitan saat menguji integrasi aplikasinya dengan API, untuk memudahkan frontend developer dalam menguji integrasi aplikasinya dengan API kita perlu membuat sebuah dummy API general yang dapat digunakan oleh frontend developer dengan bebas

## 2. Kapabilitas Sistem
Pada sistem yang dikembangkan user dapat melakukan CRUD sederhana terhadap beberapa model diantaranya adalah Person, Education, Job, Address, dan Timezone. Kelima class model tersebut saling berelasi (relasi dari class tersebut dapat dilihat pada model class diagram)

## 3. Manfaat Sistem
Sistem dapat digunakan oleh siapa saja untuk mendapatkan user dummy yang dapat digunakan dalam pengembangan aplikasi frontend atau untuk hal lain.

# B. Analisis Berorientasi Objek
## 1. Identifikasi Aktor
| No | Aktor | Deskripsi |
| -- | ----- | --------- |
| 1  | User  | User merupakan seseorang yang ingin membuat ataupun melihat user menggunakan API yang telah dikembangkan | 

## 2. Identifikasi User Stories
| No | Aktor | User Story | Acceptance Criteria |
| -- | ----- | ---------- | ------------------- | 
| 1  | User  | Sebagai developer, saya ingin membuat user random untuk menjadi dummy agar pengujian aplikasi saya lebih baik. | User dapat membuat random user. User dapat memanipulasi random user. User dapat melihat random user.
|

## 3. Indentifikasi User Case
|No|Aktor|Use Case|Brief Description|
|:----|:----|:----|:----|
|1|User|Membuat person|User membuat sebuah person dengan atribut yang diberikan|
|2|User|Meng-update person|User mengupdate atribut dari person|
|3|User|Menghapus person|User menghapus record person|
|4|User|Mencari person dari ID|User mencari person sesuai ID|
|5|User|Mencari semua person|User mencari daftar person|
|6|User|Membuat lokasi|User membuat sebuah lokasi dengan atribut yang diberikan|
|7|User|Meng-update lokasi|User mengupdate atribut dari lokasi|
|8|User|Menghapus lokasi|User menghapus record lokasi|
|9|User|Mencari lokasi dari ID|User mencari lokasi sesuai ID|
|10|User|Mencari semua lokasi|User mencari daftar lokasi|
|11|User|Membuat pekerjaan|User membuat sebuah pekerjaan dengan atribut yang diberikan|
|12|User|Meng-update pekerjaan|User mengupdate atribut dari pekerjaan|
|13|User|Menghapus pekerjaan|User menghapus record pekerjaan|
|14|User|Mencari pekerjaan dari ID|User mencari pekerjaan sesuai ID|
|15|User|Mencari semua pekerjaan|User mencari daftar pekerjaan|
|16|User|Membuat edukasi|User membuat sebuah edukasi dengan atribut yang diberikan|
|17|User|Meng-update edukasi|User mengupdate atribut dari edukasi|
|18|User|Menghapus edukasi|User menghapus record edukasi|
|19|User|Mencari edukasi dari ID|User mencari edukasi sesuai ID|
|20|User|Mencari semua edukasi|User mencari daftar edukasi|
|21|User|Membuat timezone|User membuat sebuah timezone dengan atribut yang diberikan|
|22|User|Meng-update timezone|User mengupdate atribut dari timezone|
|23|User|Menghapus timezone|User menghapus record timezone|
|24|User|Mencari timezone dari ID|User mencari timezone sesuai ID|
|25|User|Mencari semua timezone|User mencari daftar timezone|


## 4. Use Case Diagram
![use-case-diagram](https://drive.google.com/uc?export=view&id=123uXji-u0z4sYQFljTxtk8gEfNq-9pBD)

## 5. Fully Developed Use Case Description
|Use Case Name:|Membuat person|
|:----|:----|
|Scenario:|Membuat person baru.|
|Triggering Event:|User ingin membuat person baru.|
|Brief Description:|User membuat record person baru dan mengisi atribut person tersebut sesuai keinginannya.|
|Actor:|User|
|Related Use Case(s):|Dapat diubah oleh Meng-update Person dan Menghapus person|
|Stakeholders:| |
|Precondition(s):|-|
|Postcondition(s):|Person baru dibuat dan tersimpan.|
|Flow of Activities|Actor|
| |1. User membuat person baru.|
| |2. User memasukkan atribut person.|
|Flow of Activities|System|
| |1.1 System membuat person baru.|
| |1.2 System meminta input atribut person baru|
| |2.1 System menyimpan atribut|
|Exception Conditions:| |

## 6. Activity Diagram
![activity-diagram](https://drive.google.com/uc?export=view&id=188qLxJgdc5SQFrNJVYAyB2T9WSysh3r6)

## 7. Analysis of Things
|No|Things|Attributes|Kandidat Class?|
|:----|:----|:----|:----|
|1|Person|Nama, umur, tgl lahir, jenis kelamin, email, status pernikahan, foto, kewarganegaraan, agama|Person|
|2|Alamat|Nomor rumah, jalan, rt/rw, kelurahan, kecamatan, kota, provinsi,|Address|
|3|Timezone|Offset, lokasi|Timezone|
|4|Pekerjaan|Nama, posisi, gaji|Job|
|5|Institusi|Nama, tanggal join|Job|

## 8. Domain Model Class Diagram
![domain-class-diagram](https://drive.google.com/uc?export=view&id=1ScPfGdLjB-DXgkSDXd7X6BVvnGxtSfUe)

# C. Desain Berorientasi Objek

## 1. Design Principle
|Komponen|Deskripsi (Rincian + Alasan)| |
|:----|:----|:----|
|Architecture Pattern:|MVC dipilih sebab pada arsitektur MVC memisahkan program menjadi beberapa layer, sehingga kode yang dibuat menjadi lebih bersih, selain itu pemisahan program menjadi beberapa layer juga sejalan dengan prinsip separation of concern yang sangat dianjurkan dalam membuat sistem berbasis objek. Alasan lain penggunaan MVC adalah karena arsitektur ini menbuat kode program mudah diubah dan di-debug jika terjadi error| |
|Design Pattern:|Singleton (1) To Ensure that a class has just a single instance (2) To Provide a global access point to that instance|
| |Builder (1) To construct object| |

## 2. Design Class Diagram
![design-class-diagram-1](https://drive.google.com/uc?export=view&id=1GldPpj3E4r1auoEeoidglJRyfKjF4eK9)
![design-class-diagram-2](https://drive.google.com/uc?export=view&id=1ieJe3TgjY4unCQiqU9ROI8XWgM-zBzXp)

## 3. Sequence Diagram
![sequence-diagram-1](https://drive.google.com/uc?export=view&id=12OxgOD28Lorjns3bUUSxFP617h2Q0kNJ)
![sequence-diagram-1](https://drive.google.com/uc?export=view&id=1b0UxthGZqVTbCKoADB4ufv_ow1x7i-EF)
![sequence-diagram-1](https://drive.google.com/uc?export=view&id=1xIspanHZ6A2mNhzjh7aif8yzIT0DtZ0M)
![sequence-diagram-1](https://drive.google.com/uc?export=view&id=1OTsd_NmOmBmkKNX0bu_WsyD907pYE8pp)

# D. Testing Report
|Class Name:|TimezoneHelperImpl| | | |
|:----|:----|:----|:----|:----|
|Testing Scenario:| | | | |
|Method Name|Input|Expected Output|Actual Output|Results|
|generateOffset|TEST|TIME-ZONE-NOT-VALID|TIME-ZONE-NOT-VALID|Success|
|generateOffset|Asia/Jakarta|GMT+07:00"|GMT+07:00"|Success|
|Conclusion:|Testing Success| | | |

|Class Name:|AddressHelperImpl| | | |
|:----|:----|:----|:----|:----|
|Testing Scenario:| | | | |
|Method Name|Input|Expected Output|Actual Output|Results|
|toAddress|CreateAddressRequest Object|Address Object with Attribute Filled|Address Object with Attribute Filled|Success|
|toResponse|Address Object|AddressResponse Object with Attribute Filled|AddressResponse Object with Attribute Filled|Success|
|updateAddress|Old Address Object and UpdateAddressRequest Object|New Address Object with same Attribute with Request Object|New Address Object with same Attribute with Request Object|Success|
|Conclusion:|Testing Success| | | |


