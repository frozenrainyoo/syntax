// ==

const array = [1, 2, 3, 4];
const sameArray = array;
sameArray.push(5);

console.log(array !== sameArray); // false

// ==

const array = [1, 2, 3, 4];
const differentArray = [...array, 5];
// 혹은 = array.concat(5)
console.log(array === differentArray); // true

// ==

// NO
const object = {
    foo: 'hello',
    bar: 'world'
};
const sameObject = object;
sameObject.baz = 'bye';
console.log(sameObject !== object); // false

// ==

// YES
const object = {
    foo: 'hello',
    bar: 'world'
};
const differentObject = {
    ...object,
    baz: 'bye'
};
console.log(differentObject !== object); // true