# ibas-client

## Project ependencies
 - vue (vuex, vue-router,vue-i18n, vue-particles)
 - element-ui
 - axios
 - feather-icon [see usage](https://feathericons.com/).
 - animate.css
 - ...

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```

### Flow check
```
npm run flow
```

### Axios instruction
###### simple using
```
http.get('www.example.com', {
  // some config ...
}).then(data => {
  // do something ..
}, error => {
  // do something
}).catch (error => {
  // do something
})
```
###### advanced using
- nest request 
```
http.get('www.example.com',{
  // some config
}).then(data => {
  return http.get('www.someone.com',{
    // some config
  })
}).then(...)
```
- async request
```
function request1 () {
  return http.get('www.example.com',{
    // some config
  })
}

async funtion someRequests () {
  let res1 = null
  try {
    res1 = await request1
  } catch(e) {
    // do something
  }
  // ... await ...
}

```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
