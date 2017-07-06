import NativeView from "./NativeView";
/**
 * @flow
 */

const Module = {
  FuncA: require('./ModuleA'),
  FuncB: require('./ModuleB'),
  NativeView
};

module.exports = Module