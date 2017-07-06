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

import NativeView from "../../common/NativeView";

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'yellow',
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

class App extends React.Component {
  render() {
    return (
        <View style={styles.container}>
          <Text style={styles.instructions}>------------the main page start------------</Text>
            <NativeView
                style={{width:'100%',height:200}}
                componentName="active"
            />
          <Text style={styles.instructions}>To get started</Text>
          <Text style={styles.instructions}>------------main page end------------</Text>
        </View>
    );
  }
}

AppRegistry.registerComponent('main', () => App);

module.exports = App;
