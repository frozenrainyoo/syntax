// file: src/App.js
import React, { Component } from 'react';
import PhoneForm from './components/PhoneForm';

class App extends Component {
  id = 2
  state = {
    information: [
      {
        id: 0,
        name: '김민준',
        phone: '010-0000-0000'
      },
      {
        id: 1,
        name: '홍길동',
        phone: '010-0000-0001'
      }
    ]
  }
  handleCreate = (data) => {
    const { information } = this.state;
    this.setState({
      information: information.concat({ id: this.id++, ...data })
    })
  }
  render() {
    const { information } = this.state;
    return (
      <div>
        <PhoneForm
          onCreate={this.handleCreate}
        />
        {JSON.stringify(information)}
      </div>
    );
  }
}

export default App;

// file: src/components/PhoneInfo.js
import React, { Component } from 'react';

class PhoneInfo extends Component {
  static defaultProps = {
    info: {
      name: '이름',
      phone: '010-0000-0000',
      id: 0
    }
  }

  render() {
    const style = {
      border: '1px solid black',
      padding: '8px',
      margin: '8px'
    };

    const {
      name, phone, id
    } = this.props.info;

    return (
      <div style={style}>
        <div><b>{name}</b></div>
        <div>{phone}</div>
      </div>
    );
  }
}

export default PhoneInfo;


// src/components/PhoneInfoList.js
import React, { Component } from 'react';
import PhoneInfo from './PhoneInfo';

class PhoneInfoList extends Component {
  static defaultProps = {
    data: []
  }

  render() {
    const { data } = this.props;
    const list = data.map(
      info => (<PhoneInfo key={info.id} info={info}/>)
    );

    return (
      <div>
        {list}    
      </div>
    );
  }
}

export default PhoneInfoList;

// Key를 설정함으로써 불필요한 업데이트가 줄어든다. 배열의 경우 shift되어 비효율적이다.

// map 함수로 forEach보다 쉽게 사용할 수 있다.
// case 1
const a = [1, 2, 3, 4, 5];
const b = [];
b.forEach(number => b.push(number * 2));

// case 2
const a = [1, 2, 3, 4, 5];
const b = a.map(number => number * 2);

// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/map



// file: src/App.js
import React, { Component } from 'react';
import PhoneForm from './components/PhoneForm';
import PhoneInfoList from './components/PhoneInfoList';

class App extends Component {
  id = 2
  state = {
    information: [
      {
        id: 0,
        name: '김민준',
        phone: '010-0000-0000'
      },
      {
        id: 1,
        name: '홍길동',
        phone: '010-0000-0001'
      }
    ]
  }
  handleCreate = (data) => {
    const { information } = this.state;
    this.setState({
      information: information.concat({ id: this.id++, ...data })
    })
  }
  render() {
    return (
      <div>
        <PhoneForm
          onCreate={this.handleCreate}
        />
        <PhoneInfoList data={this.state.information}/>
      </div>
    );
  }
}

export default App;

// 데이터에 고유 값이 없을 수 도 있습니다.
// 그럴 때에는 만약에 key 값을 빼먹으면 렌더링이 되긴 하지만 개발자도구 콘솔에서 경고창이 뜨게 됩니다.
// 만약에 그 경고가 보고싶지 않다면 다음과 같이 작업 할 수 있습니다.
const list = data.map(
    (info, index) => (<PhoneInfo key={index} info={info}/>)
);