# Pastebin backend analog
It is necessary to design and implement a backend (REST API) for a service similar to pastebin.com - service
allows you to upload pieces of text/code ("paste") and get a short link to them, which you can send to others
people.

When loading "paste" the user specifies:
1. The period during which the "paste" will be available via the link (expiration time) 10 min., 1 hour, 3 hours, 1 day, 1 week,
1 month, without limitation after the expiration of the term, access to the "paste" is impossible, including the author
2. Access restriction:
● public — available to everyone
● unlisted — available only by link

For the downloaded paste, a short link of the form

http://my-awesome-pastebin.tld/{some-random-hash}, for example,

http://my-awesome-pastebin.tld/ab12cd34

Users can get information about the last 10 uploaded public "pastes".

## Requests


### GET
`GET /`
<sub>Return 10 public living pastes</sub>

`GET /{hash}`
<sub>Return paste by specified hash</sub>

### POST

`POST /`
<sub>Create a new paste</sub>

Example (in JSON):
```
{
    "data" : "{{$randomCompanyName}}",
    "expirationTimeSeconds" : 10,
    "publicStatus" : "PUBLIC"
}
```
