// 기존
const array = [1, 2, 3, 4, 5];
array.slice(0, 2).concat(array.slice(3, 5)) // [1, 2, 4, 5]

// or
[ ...array.slice(0, 2), ...array.slice(3, 5) ];

// or
array.filter(num => num !== 3); // [1, 2, 4, 5]

// id 를 파라미터로 받아오는 handleRemove 라는 함수를 만드시고, PhoneInfoList 로 전달하세요.
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
  handleRemove = (id) => {
    const { information } = this.state;
    this.setState({
      information: information.filter(info => info.id !== id)
    })
  }
  render() {
    const { information } = this.state;
    return (
      <div>
        <PhoneForm
          onCreate={this.handleCreate}
        />
        <PhoneInfoList 
          data={information}
          onRemove={this.handleRemove}
        />
      </div>
    );
  }
}

export default App;

// PhoneInfoList 에서는 props 로 전달받은 onRemove 를 그대로 전달해주겠습니다. 이 함수가 전달되지 않았을 경우를 대비하여 해당 props 를 위한 defaultProps 도 설정하세요.
// file: src/components/PhoneInfoList.js
import React, { Component } from 'react';
import PhoneInfo from './PhoneInfo';

class PhoneInfoList extends Component {
  static defaultProps = {
    list: [],
    onRemove: () => console.warn('onRemove not defined'),
  }

  render() {
    const { data, onRemove } = this.props;
    const list = data.map(
      info => (
        <PhoneInfo
          key={info.id}
          info={info}
          onRemove={onRemove}
        />)
    );

    return (
      <div>
        {list}    
      </div>
    );
  }
}

export default PhoneInfoList;

// 그 다음에는, PhoneInfo 쪽에서 삭제 기능을 구현해주겠습니다. 우리는 삭제 버튼을 만들어서 해당 버튼에 이벤트를 설정하겠습니다.
// PhoneInfo.js
import React, { Component } from 'react';

class PhoneInfo extends Component {
  static defaultProps = {
    info: {
      name: '이름',
      phone: '010-0000-0000',
      id: 0
    },
  }

  handleRemove = () => {
    // 삭제 버튼이 클릭되면 onRemove 에 id 넣어서 호출
    const { info, onRemove } = this.props;
    onRemove(info.id);
  }

  render() {
    const style = {
      border: '1px solid black',
      padding: '8px',
      margin: '8px'
    };

    const {
      name, phone
    } = this.props.info;

    return (
      <div style={style}>
        <div><b>{name}</b></div>
        <div>{phone}</div>
        <button onClick={this.handleRemove}>삭제</button>
      </div>
    );
  }
}

export default PhoneInfo;
