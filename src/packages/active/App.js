/**
 * @flow
 */

import React from 'react';
import {
  View,
  Text,
    AppRegistry,
    StyleSheet
} from 'react-native';
import apiMethod from './api';
import {
  FuncA, FuncB
}from '../../common';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
});

class App extends React.Component {
  render() {
    FuncA();
    FuncB();
    apiMethod();
    return (
        <View style={styles.container}>
          <Text style={styles.welcome}>
            ---the active pageage use NativeView display---
          </Text>
        </View>
    );
  }
}

AppRegistry.registerComponent('active', () => App);

module.exports = App;
