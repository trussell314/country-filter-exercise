# Country Filter Exercise

## Quickstart
### Backend:
From `backend` directory, run:

`gradlew bootRun`

Starts up on port 8888. Only one endpoint: http://localhost:8888/country

Uses https://ipgeolocationapi.com/ as the underlying API.

### Frontend:
From `frontend` directory, run:

`npm start` 

Starts up on port 3000. Accessible at http://localhost:3000.

## Notes

1. Since the list of countries pulled from the backend is
    * of a reasonable size
    * pretty darn static
    * (as I read it) meant to be "quick filter"ed in the client 

    the entire list is pulled from the backend once and then filtered in the client based on the filter text. 
1. As I proclaim on the React splash page, this is my first real attempt to use React -- it's been on my list forever. I have been mainly living in backend technologies with occasional dabbling in ExtJS and AngularJS (the old, bad one). I've already become a big fan.
1. In a production-ready product I'd add...
    * a decent styling library (e.g. Bootstrap) to the frontend. React Bootstrap actually looks pretty nice.
    * some more backend tests
    * frontend tests
