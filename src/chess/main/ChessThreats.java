package chess.main;
	




public class ChessThreats {
	
	

	
	public static void RookThreats(char color, int x, int y) {
		// UP
		int skip = 2;
		int offsetUp = 1;
		while (skip > 0) {
		    if (y - offsetUp >=0) {
		        if (ChessMain.chessBoard[y - offsetUp][x].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y - offsetUp][x] += 1;
		        		} else ChessMain.chessBoardThreatsB[y - offsetUp][x] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y - offsetUp][x] +=1;
	        		}else ChessMain.chessPsThreatsB[y - offsetUp][x] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y - offsetUp][x].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y - offsetUp][x] += 1;
		                	} else ChessMain.chessBoardThreatsB[y - offsetUp][x] += 1;
		                }
		                skip--;
		                if (color == 'W') {
		                	ChessMain.chessPsThreatsW[y - offsetUp][x] += 1;
		                } else ChessMain.chessPsThreatsB[y - offsetUp][x] += 1;
		            } else {
		                break;
		            }
		        }
		    } else skip = 0;
		    offsetUp++;
		}
		// LEFT 
		skip = 2;
		int offsetLeft = 1;
		while (skip > 0) {
		    if (x - offsetLeft >=0) {
		        if (ChessMain.chessBoard[y][x-offsetLeft].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y][x-offsetLeft] += 1;
		        		} else ChessMain.chessBoardThreatsB[y][x-offsetLeft] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y][x-offsetLeft] += 1;
	        		} else ChessMain.chessPsThreatsB[y][x-offsetLeft] +=1;
	        	}else {
		            if (ChessMain.chessBoard[y][x-offsetLeft].charAt(0) !=color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y][x-offsetLeft] += 1;
		                	} else ChessMain.chessBoardThreatsB[y][x-offsetLeft] += 1;
		                }
		                skip--;
		               if (color=='W') {
		                	ChessMain.chessPsThreatsW[y][x-offsetLeft] += 1;
		                } else ChessMain.chessPsThreatsB[y][x-offsetLeft] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetLeft++;
		}
		// DOWN
		skip = 2;
		int offsetDown = 1;
		while (skip > 0) {
		    if (y +offsetDown <=7) {
		        if (ChessMain.chessBoard[y + offsetDown][x].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y + offsetDown][x] += 1;
		        		} else ChessMain.chessBoardThreatsB[y + offsetDown][x] += 1;
		        	}
	        		if (color == 'W') {
	        			ChessMain.chessPsThreatsW[y +offsetDown][x] += 1;
	        		} else ChessMain.chessPsThreatsB[y +offsetDown][x] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y + offsetDown][x].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y + offsetDown][x] += 1;
		                	} else ChessMain.chessBoardThreatsB[y + offsetDown][x] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y +offsetDown][x] += 1;
		                } else ChessMain.chessPsThreatsB[y +offsetDown][x] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetDown++;
		}
		// RIGHT
		skip = 2;
		int offsetRight = 1;
		while (skip > 0) {
		    if (x + offsetRight <=7) {
		        if (ChessMain.chessBoard[y][x+offsetRight].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y][x+offsetRight] += 1;
		        		} else ChessMain.chessBoardThreatsB[y][x+offsetRight] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y][x+offsetRight] += 1;
	        		} else ChessMain.chessPsThreatsB[y][x+offsetRight] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y][x+offsetRight].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y][x+offsetRight] += 1;
		                	} else ChessMain.chessBoardThreatsB[y][x+offsetRight] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y][x+offsetRight] += 1;
		                } else ChessMain.chessPsThreatsB[y][x+offsetRight] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetRight++;
		}
	}
	

	
	public static void BishopThreats(char color, int x, int y, boolean switch_) {
		// UP
		int skip = 2;
		int offsetUp = 1;
		while (skip > 0) {
		    if (y - offsetUp >=0 && x-offsetUp >=0) {
		        if (ChessMain.chessBoard[y - offsetUp][x-offsetUp].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y - offsetUp][x-offsetUp] += 1;
		        		} else ChessMain.chessBoardThreatsB[y - offsetUp][x-offsetUp] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y - offsetUp][x-offsetUp] +=1;
	        		}else ChessMain.chessPsThreatsB[y - offsetUp][x-offsetUp] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y - offsetUp][x-offsetUp].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y - offsetUp][x-offsetUp] += 1;
		                	} else ChessMain.chessBoardThreatsB[y - offsetUp][x-offsetUp] += 1;
		                }
		                skip--;
		                if (color == 'W') {
		                	ChessMain.chessPsThreatsW[y - offsetUp][x-offsetUp] += (!switch_) ? 1 : -1;
		                } else ChessMain.chessPsThreatsB[y - offsetUp][x-offsetUp] += (!switch_) ? 1 : -1;
		            } else {
		                break;
		            }
		        }
		    } else skip = 0;
		    offsetUp++;
		}
		// LEFT 
		skip = 2;
		int offsetLeft = 1;
		while (skip > 0) {
		    if (x - offsetLeft >=0 && y+offsetLeft <=7) {
		        if (ChessMain.chessBoard[y+offsetLeft][x-offsetLeft].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y+offsetLeft][x-offsetLeft] += 1;
		        		} else ChessMain.chessBoardThreatsB[y+offsetLeft][x-offsetLeft] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y+offsetLeft][x-offsetLeft] += 1;
	        		} else ChessMain.chessPsThreatsB[y+offsetLeft][x-offsetLeft] +=1;
	        	}else {
		            if (ChessMain.chessBoard[y+offsetLeft][x-offsetLeft].charAt(0) !=color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y+offsetLeft][x-offsetLeft] += 1;
		                	} else ChessMain.chessBoardThreatsB[y+offsetLeft][x-offsetLeft] += 1;
		                }
		                skip--;
		               if (color=='W') {
		                	ChessMain.chessPsThreatsW[y+offsetLeft][x-offsetLeft] += 1;
		                } else ChessMain.chessPsThreatsB[y+offsetLeft][x-offsetLeft] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetLeft++;
		}
		// DOWN
		skip = 2;
		int offsetDown = 1;
		while (skip > 0) {
		    if (y +offsetDown <=7 && x+offsetDown <=7) {
		        if (ChessMain.chessBoard[y + offsetDown][x+offsetDown].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y + offsetDown][x+offsetDown] += 1;
		        		} else ChessMain.chessBoardThreatsB[y + offsetDown][x+offsetDown] += 1;
		        	}
	        		if (color == 'W') {
	        			ChessMain.chessPsThreatsW[y +offsetDown][x+offsetDown] += 1;
	        		} else ChessMain.chessPsThreatsB[y +offsetDown][x+offsetDown] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y + offsetDown][x+offsetDown].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y + offsetDown][x+offsetDown] += 1;
		                	} else ChessMain.chessBoardThreatsB[y + offsetDown][x+offsetDown] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y +offsetDown][x+offsetDown] += 1;
		                } else ChessMain.chessPsThreatsB[y +offsetDown][x+offsetDown] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetDown++;
		}
		// RIGHT
		skip = 2;
		int offsetRight = 1;
		while (skip > 0) {
		    if (x + offsetRight <=7 && y - offsetRight >=0) {
		        if (ChessMain.chessBoard[y-offsetRight][x+offsetRight].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y-offsetRight][x+offsetRight] += 1;
		        		} else ChessMain.chessBoardThreatsB[y-offsetRight][x+offsetRight] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y-offsetRight][x+offsetRight] += 1;
	        		} else ChessMain.chessPsThreatsB[y-offsetRight][x+offsetRight] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y-offsetRight][x+offsetRight].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y-offsetRight][x+offsetRight] += 1;
		                	} else ChessMain.chessBoardThreatsB[y-offsetRight][x+offsetRight] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y-offsetRight][x+offsetRight] += 1;
		                } else ChessMain.chessPsThreatsB[y-offsetRight][x+offsetRight] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetRight++;
		}
	}
	
	public static void QueenThreats(char color, int x, int y, boolean switch_) {
	// UP
		int skip = 2;
		int offsetUp = 1;
		while (skip > 0) {
		    if (y - offsetUp >=0) {
		        if (ChessMain.chessBoard[y - offsetUp][x].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y - offsetUp][x] += 1;
		        		} else ChessMain.chessBoardThreatsB[y - offsetUp][x] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y - offsetUp][x] +=1;
	        		}else ChessMain.chessPsThreatsB[y - offsetUp][x] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y - offsetUp][x].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y - offsetUp][x] += 1;
		                	} else ChessMain.chessBoardThreatsB[y - offsetUp][x] += 1;
		                }
		                skip--;
		                if (color == 'W') {
		                	ChessMain.chessPsThreatsW[y - offsetUp][x] += (!switch_) ? 1 : -1;
		                } else ChessMain.chessPsThreatsB[y - offsetUp][x] += (!switch_) ? 1 : -1;
		            } else {
		                break;
		            }
		        }
		    } else skip = 0;
		    offsetUp++;
		}
		// LEFT 
		skip = 2;
		int offsetLeft = 1;
		while (skip > 0) {
		    if (x - offsetLeft >=0) {
		        if (ChessMain.chessBoard[y][x-offsetLeft].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y][x-offsetLeft] += 1;
		        		} else ChessMain.chessBoardThreatsB[y][x-offsetLeft] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y][x-offsetLeft] += 1;
	        		} else ChessMain.chessPsThreatsB[y][x-offsetLeft] +=1;
	        	}else {
		            if (ChessMain.chessBoard[y][x-offsetLeft].charAt(0) !=color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y][x-offsetLeft] += 1;
		                	} else ChessMain.chessBoardThreatsB[y][x-offsetLeft] += 1;
		                }
		                skip--;
		               if (color=='W') {
		                	ChessMain.chessPsThreatsW[y][x-offsetLeft] += 1;
		                } else ChessMain.chessPsThreatsB[y][x-offsetLeft] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetLeft++;
		}
		// DOWN
		skip = 2;
		int offsetDown = 1;
		while (skip > 0) {
		    if (y +offsetDown <=7) {
		        if (ChessMain.chessBoard[y + offsetDown][x].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y + offsetDown][x] += 1;
		        		} else ChessMain.chessBoardThreatsB[y + offsetDown][x] += 1;
		        	}
	        		if (color == 'W') {
	        			ChessMain.chessPsThreatsW[y +offsetDown][x] += 1;
	        		} else ChessMain.chessPsThreatsB[y +offsetDown][x] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y + offsetDown][x].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y + offsetDown][x] += 1;
		                	} else ChessMain.chessBoardThreatsB[y + offsetDown][x] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y +offsetDown][x] += 1;
		                } else ChessMain.chessPsThreatsB[y +offsetDown][x] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetDown++;
		}
		// RIGHT
		skip = 2;
		int offsetRight = 1;
		while (skip > 0) {
		    if (x + offsetRight <=7) {
		        if (ChessMain.chessBoard[y][x+offsetRight].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y][x+offsetRight] += 1;
		        		} else ChessMain.chessBoardThreatsB[y][x+offsetRight] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y][x+offsetRight] += 1;
	        		} else ChessMain.chessPsThreatsB[y][x+offsetRight] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y][x+offsetRight].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y][x+offsetRight] += 1;
		                	} else ChessMain.chessBoardThreatsB[y][x+offsetRight] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y][x+offsetRight] += 1;
		                } else ChessMain.chessPsThreatsB[y][x+offsetRight] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetRight++;
		}
		
		// UP
		skip = 2;
		offsetUp = 1;
		while (skip > 0) {
		    if (y - offsetUp >=0 && x-offsetUp >=0) {
		        if (ChessMain.chessBoard[y - offsetUp][x-offsetUp].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y - offsetUp][x-offsetUp] += 1;
		        		} else ChessMain.chessBoardThreatsB[y - offsetUp][x-offsetUp] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y - offsetUp][x-offsetUp] +=1;
	        		}else ChessMain.chessPsThreatsB[y - offsetUp][x-offsetUp] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y - offsetUp][x-offsetUp].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y - offsetUp][x-offsetUp] += 1;
		                	} else ChessMain.chessBoardThreatsB[y - offsetUp][x-offsetUp] += 1;
		                }
		                skip--;
		                if (color == 'W') {
		                	ChessMain.chessPsThreatsW[y - offsetUp][x-offsetUp] += (!switch_) ? 1 : -1;
		                } else ChessMain.chessPsThreatsB[y - offsetUp][x-offsetUp] += (!switch_) ? 1 : -1;
		            } else {
		                break;
		            }
		        }
		    } else skip = 0;
		    offsetUp++;
		}
		// LEFT 
		skip = 2;
		offsetLeft = 1;
		while (skip > 0) {
		    if (x - offsetLeft >=0 && y+offsetLeft <=7) {
		        if (ChessMain.chessBoard[y+offsetLeft][x-offsetLeft].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y+offsetLeft][x-offsetLeft] += 1;
		        		} else ChessMain.chessBoardThreatsB[y+offsetLeft][x-offsetLeft] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y+offsetLeft][x-offsetLeft] += 1;
	        		} else ChessMain.chessPsThreatsB[y+offsetLeft][x-offsetLeft] +=1;
	        	}else {
		            if (ChessMain.chessBoard[y+offsetLeft][x-offsetLeft].charAt(0) !=color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y+offsetLeft][x-offsetLeft] += 1;
		                	} else ChessMain.chessBoardThreatsB[y+offsetLeft][x-offsetLeft] += 1;
		                }
		                skip--;
		               if (color=='W') {
		                	ChessMain.chessPsThreatsW[y+offsetLeft][x-offsetLeft] += 1;
		                } else ChessMain.chessPsThreatsB[y+offsetLeft][x-offsetLeft] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetLeft++;
		}
		// DOWN
		skip = 2;
		offsetDown = 1;
		while (skip > 0) {
		    if (y +offsetDown <=7 && x+offsetDown <=7) {
		        if (ChessMain.chessBoard[y + offsetDown][x+offsetDown].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y + offsetDown][x+offsetDown] += 1;
		        		} else ChessMain.chessBoardThreatsB[y + offsetDown][x+offsetDown] += 1;
		        	}
	        		if (color == 'W') {
	        			ChessMain.chessPsThreatsW[y +offsetDown][x+offsetDown] += 1;
	        		} else ChessMain.chessPsThreatsB[y +offsetDown][x+offsetDown] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y + offsetDown][x+offsetDown].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y + offsetDown][x+offsetDown] += 1;
		                	} else ChessMain.chessBoardThreatsB[y + offsetDown][x+offsetDown] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y +offsetDown][x+offsetDown] += 1;
		                } else ChessMain.chessPsThreatsB[y +offsetDown][x+offsetDown] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetDown++;
		}
		// RIGHT
		skip = 2;
		offsetRight = 1;
		while (skip > 0) {
		    if (x + offsetRight <=7 && y - offsetRight >=0) {
		        if (ChessMain.chessBoard[y-offsetRight][x+offsetRight].charAt(0) == ' ' ) {
		        	if (skip>1) {
		        		if (color=='W') {
		        			ChessMain.chessBoardThreatsW[y-offsetRight][x+offsetRight] += 1;
		        		} else ChessMain.chessBoardThreatsB[y-offsetRight][x+offsetRight] += 1;
		        	}
	        		if (color=='W') {
	        			ChessMain.chessPsThreatsW[y-offsetRight][x+offsetRight] += 1;
	        		} else ChessMain.chessPsThreatsB[y-offsetRight][x+offsetRight] += 1;
	        	}else {
		            if (ChessMain.chessBoard[y-offsetRight][x+offsetRight].charAt(0) != color) {
		                if (skip>1) {
		                	if (color=='W') {
		                		ChessMain.chessBoardThreatsW[y-offsetRight][x+offsetRight] += 1;
		                	} else ChessMain.chessBoardThreatsB[y-offsetRight][x+offsetRight] += 1;
		                }
		                skip--;
		                if (color=='W') {
		                	ChessMain.chessPsThreatsW[y-offsetRight][x+offsetRight] += 1;
		                } else ChessMain.chessPsThreatsB[y-offsetRight][x+offsetRight] += 1;
		            } else {
		                break;
		            }
		        }
		    } else {
		        skip = 0;
		    }
		    offsetRight++;
		}
	}
	
	public static void KingThreats(char color, int x, int y, boolean switch_) {
		// try { // UP
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y-1][x] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y-1][x] += 1;
		// } catch (Exception e) {}
		// try { // UP LEFT
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y-1][x-1] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y-1][x-1] += 1;
		// } catch (Exception e) {}
		// try { // LEFT
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y][x-1] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y][x-1] += 1;
		// } catch (Exception e) {}
		// try { // DOWN LEFT
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y+1][x-1] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y+1][x-1] += 1;
		// } catch (Exception e) {}
		// try { // DOWN
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y+1][x] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y+1][x] += 1;
		// } catch (Exception e) {}
		// try { // DOWN RIGHT
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y+1][x+1] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y+1][x+1] += 1;
		// } catch (Exception e) {}
		// try { // RIGHT
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y][x+1] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y][x+1] += 1;
		// } catch (Exception e) {}
		// try { // UP RIGHT
		// 	if (color=='W') {
		// 		ChessMain.chessBoardThreatsW[y-1][x+1] += 1;
		// 	} else ChessMain.chessBoardThreatsB[y-1][x+1] += 1;
		// } catch (Exception e) {}
	}
	
	
	public static Integer isKingCell(char color, int x, int y) {
		
		if (color == 'W') {
			if (x==ChessPieces.kingXb && y==ChessPieces.kingYb) {
				return 1;
			} else return 0;
		} else if (color == 'B') {
			if (x==ChessPieces.kingXw && y==ChessPieces.kingYw) {
				return 1;
			} else return 0;
		}
		return 0;

	}
	
}
