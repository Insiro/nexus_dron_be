# Project: nexus_drone

## End-point: get types

### Method: GET

> ```
> {{url}}/drones/types
> ```

### Response: 200

```json
[
    {
        "name": "test type",
        "uid": 2
    }
]
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: new Type

### Method: POST

> ```
> {{url}}/drones/types
> ```

### Body (**raw**)

```json
{
    "name": "test type"
}
```

### Response: 200

```json
{
    "name": "test type",
    "uid": 2
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get type info

### Method: GET

> ```
> {{url}}/drones/types/{{typeId}}
> ```

### Response: 201

```json
{
    "name": "test type",
    "uid": 2
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: update type

### Method: PUT

> ```
> {{url}}/drones/types/{{typeId}}
> ```

### Body (**raw**)

```json
{
    "name": "name2"
}
```

### Response: 200

```json
{
    "name": "name2",
    "uid": 1
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: delete type

### Method: DELETE

> ```
> {{url}}/drones/types/{{typeId}}
> ```

### Response: 200

```json
Success
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get states

### Method: GET

> ```
> {{url}}/drones/states
> ```

### Response: 200

```json
[
    {
        "uid": 1,
        "name": "not initalized"
    },
    {
        "uid": 2,
        "name": "sharging"
    },
    {
        "uid": 3,
        "name": "delivering"
    },
    {
        "uid": 4,
        "name": "idle"
    },
    {
        "uid": 5,
        "name": "returning"
    },
    {
        "uid": 6,
        "name": "maintanacing"
    },
    {
        "uid": 7,
        "name": "lost"
    }
]
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: new state

### Method: POST

> ```
> {{url}}/drones/states
> ```

### Body (**raw**)

```json
{
    "name": "new state"
}
```

### Response: 200

```json
{
    "uid": 8,
    "name": "new state"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: delete state

### Method: DELETE

> ```
> {{url}}/drones/states/{{stateId}}
> ```

### Response: 403

```json
Forbidden
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: edit State

### Method: PUT

> ```
> {{url}}/drones/states/{{stateId}}
> ```

### Body (**raw**)

```json
{
    "name": "1111"
}
```

### Response: 403

```json
Forbidden
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get state info

### Method: GET

> ```
> {{url}}/drones/states/{{stateId}}
> ```

### Response: 201

```json
{
    "uid": 7,
    "name": "lost"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get models

### Method: GET

> ```
> {{url}}/drones/models
> ```

### Response: 200

```json
[
    {
        "uid": "85eca091-c355-4dbe-99bd-44d41efb9342",
        "name": "model1"
    },
    {
        "uid": "a2231b89-fa57-4d88-99ad-2e4c6d14c066",
        "name": "model2"
    }
]
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: new Post

### Method: POST

> ```
> {{url}}/drones/models
> ```

### Body (**raw**)

```json
{
    "name": "model2"
}
```

### Response: 201

```json
{
    "uid": "a2231b89-fa57-4d88-99ad-2e4c6d14c066",
    "name": "model2"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get model information

### Method: GET

> ```
> {{url}}/drones/models/{{modelId}}
> ```

### Response: 200

```json
{
    "uid": "a2231b89-fa57-4d88-99ad-2e4c6d14c066",
    "name": "model2"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: update model

### Method: PUT

> ```
> {{url}}/drones/models/{{modelId}}
> ```

### Body (**raw**)

```json
{
    "name": "new name"
}
```

### Response: 200

```json
{
    "uid": "a2231b89-fa57-4d88-99ad-2e4c6d14c066",
    "name": "new name"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: delete model

### Method: DELETE

> ```
> {{url}}/drones/models/{{modelId}}
> ```

### Response: 200

```json
success
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: add drone

### Method: POST

> ```
> {{url}}/drones
> ```

### Body (**raw**)

```json
{
    "droneName": "drone1",
    "droneModel": "12345678-1234-5678-1234-567812345678",
    "manageDate": "2023-05-24",
    "typeId": 0
}
```

### Response: 200

```json
{
    "uid": "c373599e-1a37-41f1-8572-75afaef4276a",
    "name": "drone1",
    "position": {
        "latitude": 0,
        "longitude": 0
    },
    "battery": 0,
    "manageDate": "2024-05-24T03:35:58.891+00:00",
    "stateId": 0,
    "typeId": 0,
    "modelId": "12345678-1234-5678-1234-567812345678"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get drone list

### Method: GET

> ```
> {{url}}/drones/
> ```

### Response: 200

```json
[
    {
        "uid": "442dd4cc-3f40-4e6b-ae21-c60fda979b6d",
        "name": "drone1",
        "position": {
            "latitude": 0,
            "longitude": 0
        },
        "battery": 0,
        "manageDate": "2024-05-24T03:35:58.891+00:00",
        "stateId": 0,
        "typeId": 0,
        "modelId": "12345678-1234-5678-1234-567812345678"
    }
]
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: delete drone

### Method: DELETE

> ```
> {{url}}/drones/{{droneId}}
> ```

### Response: 200

```json
Success
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: get drone info

### Method: GET

> ```
> {{url}}/drones/{{droneId}}
> ```

### Response: 201

```json
{
    "uid": "da47f68f-2ebe-4fda-9c6c-1dc3b3706930",
    "name": "drone1",
    "position": {
        "latitude": 0,
        "longitude": 0
    },
    "battery": 0,
    "manageDate": "2024-05-24T03:41:17.497+00:00",
    "stateId": 0,
    "typeId": 0,
    "modelId": "12345678-1234-5678-1234-567812345678"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Update Drone

all request body parament are optional

### Method: PUT

> ```
> {{url}}/drones/{{droneId}}
> ```

### Body (**raw**)

```json
{
    "battery": 51,
    "stateId": 2,
    "typeId": 2,
    "position": {
        "longitude": 1.0,
        "latitude": "1.0"
    },
    "manageDate": "2024-06-24T06:25:57.384+00:00"
}
```

### Response: 200

```json
{
    "uid": "48c30435-0b9b-412a-86c4-d0b45cab0263",
    "name": "drone1",
    "position": {
        "latitude": 1,
        "longitude": 1
    },
    "battery": 0,
    "manageDate": "2024-06-24T06:25:57.384+00:00",
    "stateId": 2,
    "typeId": 2,
    "modelId": "12345678-1234-5678-1234-567812345678"
}
```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

---
