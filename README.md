# API SPEC

## Authentication

All API must use this authentication

Request:
- Header :
  - X-Api_key : "your secret api key"

## CREATE PRODUCT

Request :
- Method : POST
- Endpoint : `api/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body : 

```json
{
    "id" : "string, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer"
}
```
Response:

```json
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "name" : "string",
         "price" : "long",
         "quantity" : "integer",
         "createdAt" : "date"
    }
}
```

## GET PRODUCT

Request :
- Method : GET
- Endpoint : `api/products/{id_product}`
- Header :
    - Accept: application/json
Response:

```json
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "name" : "string",
         "price" : "long",
         "quantity" : "integer",
         "createdAt" : "date",    
         "updatedAt" : "date" 
    }
}
```

## UPDATE PRODUCT

Request :
- Method : PUT
- Endpoint : `api/products/{id_product}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json
{
    "name" : "string",
    "price" : "long",
    "quantity" : "integer"
}
```
Response:

```json
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "name" : "string",
         "price" : "long",
         "quantity" : "integer",
         "createdAt" : "date",    
         "updatedAt" : "date" 
    }
}
```

## LIST PRODUCT

Request :
- Method : GET
- Endpoint : `api/products`
- Header :    
    - Accept: application/json
- Query Param :
  - pageSize : number,
  - page : number
  
Response:

```json
{
    "code" : "number",
    "status" : "string",
    "data" : [
        {
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity" : "integer",
            "createdAt" : "date",    
            "updatedAt" : "date" 
        },
        {
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity" : "integer",
            "createdAt" : "date",    
            "updatedAt" : "date" 
        }
   ]
}
```

## DELETE PRODUCT

Request :
- Method : DELETE
- Endpoint : `api/products/{id_product}`
- Header :
    - Accept: application/json
  
Response:

```json
{
    "code" : "number",
    "status" : "string"
}
```