# osu-kt

## WIP!

This is an osu! API wrapper written in Kotlin. The main goal is to create a usable API wrapper for our Discord bot project [NaersinBot-JDA](https://github.com/krsmll/NaersinBot-JDA).

## Usage

All you have to do before using this wrapper is initiate Client with your osu! client secret and client ID like so:

```kotlin
Client(CLIENT_ID, CLIENT_SECRET)
// You do not need to store this in a variable. Client is written in singleton pattern.
```

After initializing the Client, you can proceed with using the wrapper.

```kotlin
User.get(...)
Score.get(...)
Beatmap.get(...)
// etc
```
