
# UnscramblerWord

Enter letters that get unscrambled to display all dictionary words these letters can spell.

## API

http://**{host}**/**{lang}**/word/**{letters}**

Example

```
http://localhost:8080/en/word/mgimnrapgro
```


Response

```
[
  {
    "size": 11,
    "string": "programming",
    "lang": "EN"
  },
  {
    "size": 10,
    "string": "programing",
    "lang": "EN"
  },
  {
    "size": 10,
    "string": "programmng",
    "lang": "EN"
  },
  {
    "size": 8,
    "string": "armoring",
    "lang": "EN"
  },
  {
    "size": 8,
    "string": "majoring",
    "lang": "EN"
  },
  {
    "size": 7,
    "string": "gamming",
    "lang": "EN"
  },
  ...
```

## Dictionary

[Беларускі](https://github.com/blrB/BelarusianSlounik)

[Русский](http://www.speakrus.ru/dict/)

[English](https://github.com/dwyl/english-words)
