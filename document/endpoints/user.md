# Project: Nexus_drone User_service

This is about Nexus_drone_user_service

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Change UserInfo

### Method: PUT

> ```
> {{url}}/api/user/{{userID}}
> ```

### Response: 200

```json
{
    "uuid": 1,
    "permission": 1,
    "pwd": "3",
    "img": "https://swingbrowser.userecho.com/s/cache/b5/09/b5098d61f3ef34b35311456b08123897.png",
    "id": "3"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get UserInfo

### Method: GET

> ```
> {{url}}/api/user/{{userID}}
> ```

### Response: 200

```json
{
    "uuid": 1,
    "permission": 1,
    "pwd": "3",
    "img": "https://swingbrowser.userecho.com/s/cache/b5/09/b5098d61f3ef34b35311456b08123897.png",
    "id": "3"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get All UserInfo

### Method: GET

> ```
> {{url}}/api/user
> ```

### Response: 200

```json
[
    {
        "uuid": 1,
        "permission": 1,
        "pwd": "3",
        "img": "https://swingbrowser.userecho.com/s/cache/b5/09/b5098d61f3ef34b35311456b08123897.png",
        "id": "3"
    },
    {
        "uuid": 2,
        "permission": 1,
        "pwd": "2",
        "img": "https://swingbrowser.userecho.com/s/cache/b5/09/b5098d61f3ef34b35311456b08123897.png",
        "id": "2"
    },
    {
        "uuid": 3,
        "permission": 1,
        "pwd": "1",
        "img": "https://swingbrowser.userecho.com/s/cache/b5/09/b5098d61f3ef34b35311456b08123897.png",
        "id": "test"
    }
]
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

---

Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
