state = {
    number: 0,
    foo: 'bar'
}

state = {
    number: 0,
    foo: {
        bar: 0,
        foobar: 1
    }
}

// ...은 자바스크립트의 전개연산자 입니다.
// 기존의 객체안에 있는 내용을 해당 위치에다가 풀어준다는 의미
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Spread_operator
this.setState({
    number: 0,
    foo: {
        ...this.state.foo,
        foobar: 2
    }
});

// setState에 객체 대신 함수를 전달하기

this.setState({
    number: this.state.number + 1
});

this.setState(
    (state) => ({
        number: state.number
    })
);

this.setState(
  ({ number }) => ({
    number: number + 1
  })
);
//  (state) 가 ({ number }) 가 됐죠? 이건 비구조화 할당 이라는 문법입니다.
// 이같이도 사용할 수 있음 const { number } = this.state;

const { number } = this.state;
this.setState({
  number: number + 1
})

// 맘에드는 코드로 사용..
