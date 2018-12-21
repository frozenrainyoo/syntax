// https://code.likeagirl.io/understanding-react-component-life-cycle-49bf4b8674de
// https://react-anyone.vlpt.us/05.html

// 컴포넌트 생성자 함수, 컴포넌트가 새로 만들어질 때마다 호출
constructor(props) {
    super(props);
}

// deprecated v16.3 컴포넌트가 여러분의 화면에 나가나기 직전에 호출되는 API, UNSAFE_componentWillMount로 사용가능
componentWillMount() {

}

// API 는 여러분의 컴포넌트가 화면에 나타나게 됐을 때 호출
componentDidMount() {
    // 외부 라이브러리 연동: D3, masonry, etc
    // 컴포넌트에서 필요한 데이터 요청: Ajax, GraphQL, etc
    // DOM 에 관련된 작업: 스크롤 설정, 크기 읽어오기 등
}

// # 컴포넌트 업데이트

// deprecated v16.3 컴포넌트가 새로운 props 를 받게됐을 때 호출
// 이 기능은 상황에 따라 새로운 API getDerivedStateFromProps 로 대체 될 수 있음
componentWillReceiveProps(nextProps) {
    // this.props 는 아직 바뀌지 않은 상태
}

// props 로 받아온 값을 state 로 동기화 하는 작업을 해줘야 하는 경우에 사용
static getDerivedStateFromProps(nextProps, prevState) {
    // 여기서는 setState 를 하는 것이 아니라
    // 특정 props 가 바뀔 때 설정하고 설정하고 싶은 state 값을 리턴하는 형태로
    // 사용됩니다.
    /*
    if (nextProps.value !== prevState.value) {
      return { value: nextProps.value };
    }
    return null; // null 을 리턴하면 따로 업데이트 할 것은 없다라는 의미
    */
}

// 컴포넌트를 최적화하는 작업에서 매우 유용하게 사용
shouldComponentUpdate(nextProps, nextState) {
    // return false 하면 업데이트를 안함
    // return this.props.checked !== nextProps.checked
    return true;
}

// deprecated v16.3 shouldComponentUpdate 에서 true 를 반환했을때만 호출
// 여기선 주로 애니메이션 효과를 초기화하거나, 이벤트 리스너를 없애는 작업을 합니다. 이 함수가 호출되고난 다음에는, render() 가 호출됩니다.
// 기존의 기능은 getSnapshotBeforeUpdate 로 대체 될 수 있습니다.
componentWillUpdate(nextProps, nextState) {

}


// 이 API 가 발생하는 시점은 다음과 같습니다.

// 1. render()
// 2. getSnapshotBeforeUpdate()
// 3. 실제 DOM 에 변화 발생
// 4. componentDidUpdate
// 이 API를 통해서, DOM 변화가 일어나기 직전의 DOM 상태를 가져오고, 여기서 리턴하는 값은 componentDidUpdate 에서 3 번째 파라미터로 받아올 수 있게 됩니다.
// 전체코드는 https://codesandbox.io/s/484zvr87ow 에서 확인
getSnapshotBeforeUpdate(prevProps, prevState) {
// DOM 업데이트가 일어나기 직전의 시점입니다.
// 새 데이터가 상단에 추가되어도 스크롤바를 유지해보겠습니다.
// scrollHeight 는 전 후를 비교해서 스크롤 위치를 설정하기 위함이고,
// scrollTop 은, 이 기능이 크롬에 이미 구현이 되어있는데, 
// 이미 구현이 되어있다면 처리하지 않도록 하기 위함입니다.
if (prevState.array !== this.state.array) {
    const {
    scrollTop, scrollHeight
    } = this.list;

    // 여기서 반환 하는 값은 componentDidMount 에서 snapshot 값으로 받아올 수 있습니다.
    return {
    scrollTop, scrollHeight
    };
}
}

componentDidUpdate(prevProps, prevState, snapshot) {
if (snapshot) {
    const { scrollTop } = this.list;
    if (scrollTop !== snapshot.scrollTop) return; // 기능이 이미 구현되어있다면 처리하지 않습니다.
    const diff = this.list.scrollHeight - snapshot.scrollHeight;
    this.list.scrollTop += diff;
}
}

// 컴포넌트에서 render() 를 호출하고난 다음에 발생
// 이 시점에선 this.props 와 this.state 가 바뀌어있습니다
// 파라미터를 통해 이전의 값인 prevProps 와 prevState 를 조회 할 수 있습니다.
// 그리고, getSnapshotBeforeUpdate 에서 반환한 snapshot 값은 세번째 값으로 받아옵니다.
componentDidUpdate(prevProps, prevState, snapshot) {

}

// # 컴포넌트 제거

// 주로 등록했었던 이벤트를 제거하고, 만약에 setTimeout 을 걸은것이 있다면 clearTimeout 을 통하여 제거를 합니다.
// 추가적으로, 외부 라이브러리를 사용한게 있고 해당 라이브러리에 dispose 기능이 있다면 여기서 호출해주시면 됩니다.
componentWillUnmount() {
    // 이벤트, setTimeout, 외부 라이브러리 인스턴스 제거
}

// # 컴포넌트에 에러 발생

// 에러가 발생하면 이런식으로 componentDidCatch 가 실행되게 하고, state.error 를 true 로 설정하게 하고,
// render 함수쪽에서 이에 따라 에러를 띄워주시면 됩니다.
// 이 API 를 사용하시게 될 때 주의하실 점이 있는데요, 컴포넌트 자신의 render 함수에서 에러가 발생해버리는것은 잡아낼 수는 없지만,
// 그 대신에 컴포넌트의 자식 컴포넌트 내부에서 발생하는 에러들을 잡아낼 수 있습니다
componentDidCatch(error, info) {
    this.setState({
        error: true
    });
}

// 자식 컴포넌트 내부에서 발생하는 에러 잡는 예시
import React, { Component } from 'react';

const Problematic = () => {
  throw (new Error('버그가 나타났다!'));
  return (
    <div>

    </div>
  );
};

class Counter extends Component {
  // ... 생략

  render() {
    return (
      <div>
        <h1>카운터</h1>
        <div>값: {this.state.number}</div>
        { this.state.number === 4 && <Problematic /> }
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
      </div>
    );
  }
}

export default Counter;

/////////////////////////
import React, { Component } from 'react';

const Promblematic = () => {
  throw (new Error('버그가 나타났다!'));
  return (
    <div>

    </div>
  );
};

class Counter extends Component {
  state = {
    number: 0,
    error: false
  }

  // (...)

  componentDidCatch(error, info) {
    this.setState({
      error: true
    });
  }

  render() {
    if (this.state.error) return (<h1>에러발생!</h1>);

    return (
      <div>
        <h1>카운터</h1>
        <div>값: {this.state.number}</div>
        { this.state.number === 4 && <Promblematic /> }
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
      </div>
    );
  }
}

export default Counter;

// Example

import React, { Component } from 'react';

class Counter extends Component {
  state = {
    number: 0
  }

  constructor(props) {
    super(props);
    console.log('constructor');
  }

  componentWillMount() {
    console.log('componentWillMount (deprecated)');
  }

  componentDidMount() {
    console.log('componentDidMount');
  }

  shouldComponentUpdate(nextProps, nextState) {
    // 5 의 배수라면 리렌더링 하지 않음
    console.log('shouldComponentUpdate');
    if (nextState.number % 5 === 0) return false;
    return true;
  }

  componentWillUpdate(nextProps, nextState) {
    console.log('componentWillUpdate');
  }

  componentDidUpdate(prevProps, prevState) {
    console.log('componentDidUpdate');
  }


  handleIncrease = () => {
    const { number } = this.state;
    this.setState({
      number: number + 1
    });
  }

  handleDecrease = () => {
    this.setState(
      ({ number }) => ({
        number: number - 1
      })
    );
  }

  render() {
    console.log('render');
    return (
      <div>
        <h1>카운터</h1>
        <div>값: {this.state.number}</div>
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
      </div>
    );
  }
}

export default Counter;
