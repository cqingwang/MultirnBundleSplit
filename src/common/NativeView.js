import React,{PropTypes} from 'react'
import { requireNativeComponent,View } from 'react-native'

const iface = {
    name: 'ReactNativeView',
    propTypes: {
        componentName: PropTypes.string,
        ...View.propTypes // 包含默认的View的属性
    },
};

export default requireNativeComponent('RCTReactNativeView', iface);
