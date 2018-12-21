// var 은 scope 가 함수단위
function foo() {
    var a = 'hello';
    if (true) {
        var a = 'bye';
        console.log(a); // bye
    }
    console.log(a); // bye
}

// 반면 const 와 let 은 scope 가 블록 단위
function foo() {
    let a = 'hello';
    if (true) {
        let a = 'bye';
        console.log(a); // bye
    }
    console.log(a); // hello
}

// ES6 에서는 var 을 쓸 일이 없고, 값을 선언 후 바꿔야 할 땐 let, 그리고 바꾸지 않을 땐 const 를 사용하면 됨
