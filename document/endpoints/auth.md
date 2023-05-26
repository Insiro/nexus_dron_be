# Project: JWT Auth + Gateway

# Introduction

JWT Token Make and ReFresh, and check API Gateway JWT token filter check

## End-point: Get New JWT Token

### Method: GET

> ```
> {{url}}/auth/getToken
> ```

### Response: 200

```json
{
    "AccessKey": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJURVNUX1VVSUQiLCJleHAiOjE2ODQ5MzA0NjgsInVzZXIiOnsiUm9sZSI6IlRFU1RfUk9MRSIsIlVVSUQiOiJURVNUX1VVSUQifX0.ZxiEveBELJqm9xld39N2n8P2iV-gKRR-hCZEW_apMQsVXkKEsUKxrZNZ_gLXpPAPb66JoQSarPyM2dPKTQl70w",
    "message": "AccessKey, RefreshKey 생성완료",
    "RefreshKey": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJURVNUX1VVSUQiLCJleHAiOjE2ODUxNzE2NjgsInVzZXIiOnsiUm9sZSI6IlRFU1RfUk9MRSIsIlVVSUQiOiJURVNUX1VVSUQifX0.aJ-80pG5bE7oLLNccQxXO3Q-6WLLDKQmt6y1mdDBhg_fJ_dRjn1p-ZpfDWimAZPjcpt_F2mgWwMMNXuVdFro1Q",
    "status": "200"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Refresh_JWT_Token

### Method: GET

> ```
> {{url}}/auth/getToken/refresh
> ```

### Response: 200

```json
{
    "message": "Refresh 토큰을 통한 Access Token 생성이 완료되었습니다.",
    "accessToken": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJURVNUX1VVSUQiLCJleHAiOjE2ODQ5MzA2MDQsInVzZXIiOnsiUm9sZSI6IlRFU1RfUk9MRSIsIlVVSUQiOiJURVNUX1VVSUQifX0.wtiADSrRFwmJNsz05B1P0pqpQ-yjyG2VsfzQp_nCtuIpSB-Mg4UYubVtNzBjIDfZftlyHSf-ymp9k6sgqPqp_g",
    "status": "200"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: JWT_TEST(with JWT Token)

### Method: GET

> ```
> {{url}}/auth/getToken/newNotice
> ```

### Response: 200

```json
notice create ok
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: JWT_TEST(without JWT Token)

### Method: GET

> ```
> {{url}}/auth/getToken/newNotice
> ```

### Response: 200

```json
{ "errorCode": 500 }
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

---

## End-point: Login

### Method: POST

> ```
> {{url}}/api/auth
> ```

### Body (**raw**)

```json
{
    "id": "{{ID}}",
    "pwd": "{{pwd}}"
}
```

### Response: 200

```json
{
    "AccessKey": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIzIiwiZXhwIjoxNjg1MTAwMzAxLCJ1c2VyIjp7IlJvbGUiOiIxIiwiVVVJRCI6IjMifX0.j5SLjB9eK7v-ENYDgBCRXRkbz1mfVB7xeaAy4XKhKOJJTsqzRI8-tJG_Ux0T0PKoMqtyFiTJ5VwrhLTPhM_4UA",
    "message": "AccessKey, RefreshKey 생성완료",
    "RefreshKey": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIzIiwiZXhwIjoxNjg1MzQxNTAxLCJ1c2VyIjp7IlJvbGUiOiIxIiwiVVVJRCI6IjMifX0.MgiwebAHVqpz764t2NMMFJq9GBGk4WX_SycbRc9NmDI1ywfRfNEZBxPTTYZxM81Y-DKwmt3xYyRdhAo9LOVI6w",
    "status": "200"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Register

### Method: POST

> ```
> {{url}}/api/auth/register
> ```

### Body (**raw**)

```json
{
    "id": "{{ID}}",
    "pwd": "{{pwd}}"
}
```

### Response: 200

```json
1
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
