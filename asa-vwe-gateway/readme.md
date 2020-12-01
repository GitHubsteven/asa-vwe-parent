user.schema
```
let schema = new Schema({
    username: {type: String, unique: true, required: true},
    hash: {type: String, required: true},
    email: {type: String, required: true},
    password: {type: String, default: ""},
    role: {type: String, default: "user"},
    createTime: {type: Date, default: Date.now},
    creator: {type: String, default: "admin"},
    modifiedTime: {type: Date, default: Date.now},
    modifier: {type: String, default: "admin"}
});
```