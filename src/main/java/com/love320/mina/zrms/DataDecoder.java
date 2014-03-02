package com.love320.mina.zrms;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

public class DataDecoder implements MessageDecoder  {
	
	private final Logger log = Logger.getLogger(ServerHandler.class.getName());

	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		return MessageDecoderResult.OK;
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in,ProtocolDecoderOutput out ) throws Exception {
		
		String txt = in.getHexDump(in.remaining());
		log.info("完整的原始数据Hex码-全包：" + txt);
		out.write(txt);
		//System.out.println(">>"+DataBagUtil.isCheckCodeCRC(array));
		
		byte[] b = new byte[in.remaining()];
		in.get(b);
		in.free();
		
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		
	}




}
