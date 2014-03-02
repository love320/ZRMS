package com.love320.mina.zrms;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;


public  class ServerCodeFactory extends DemuxingProtocolCodecFactory {

	ServerCodeFactory(){
		super.addMessageDecoder(new DataDecoder());//解码器
	}
	
}
