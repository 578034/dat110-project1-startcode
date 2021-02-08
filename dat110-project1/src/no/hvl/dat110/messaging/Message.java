package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		 // TODO: check for length within boundary
		if (payload.length <= 127) {
			this.payload = payload;
		} else {
		    this.payload = null;
		   
	    }
	}		

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded;
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		encoded = new byte[128];
		encoded[0] = (byte) payload.length;
		for (int i = 1; i <= payload.length; i++) {
			encoded[i] = payload[i - 1];
		}

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		payload = new byte[received[0]];
		for (int i = 1; i <= received[0]; i++) {
			payload[i - 1] = received[i];
		}
		
	}
}
