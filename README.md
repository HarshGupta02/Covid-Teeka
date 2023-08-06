# Covid Teeka

The government of India has started the biggest vaccination drive across India to give vaccination to people to fight against the COVID-19 virus. As there are so many vaccination centers in India for vaccination so to check the availability of different vaccination in different centers across India. Hence we build a simple application for getting the details about vaccination centers in India.

## API Reference

#### Get all Vaccination Centers

```http
  GET https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin
```

| Query Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Pincode` | `String` | Queries All Centers based on Pincode |
| `Date` | `Date` | Queries All Centers based on date of Availability |

#### getAppointments(pincode, date)

Takes the pincode of the user where the user is residing and takes the data on which the Availability of centers needed to be queried.


## Screenshots

![WhatsApp Image 2023-08-06 at 12 04 38 PM](https://github.com/HarshGupta02/Covid-Teeka/assets/77138269/5db86051-f53d-4a52-b7f6-d4b83fffcfa3)

![WhatsApp Image 2023-08-06 at 12 04 37 PM](https://github.com/HarshGupta02/Covid-Teeka/assets/77138269/bddb5b2c-d88d-4f6c-846b-98210864b29f)

![Screenshot (801)](https://github.com/HarshGupta02/Covid-Teeka/assets/77138269/382379a0-dae7-44e1-8c8c-8de4d7d37945)
