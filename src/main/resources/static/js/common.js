/*
 * IE9 console.log 버그 픽스
 */
window.mode = 'test';
if(window.mode == 'test'){
	if(!window.console){
		console = {
			log:function(){}
		}
	}
} else { // real 모드
	window.console = {
		log:function(){}
	}
}

/*
 * 콤보박스 항목 설명
 * 
 * data: DB에서 가져오는 result값
 * base_target: 서브콤보의 영향을 미치는 상위콤보의 엘리먼트 명(attribute name)
 * name: 해당 엘리먼트 명(attribute name)
 * follower: 상위콤보의 변화에 따라 해당 서브콤보의 아이템을 변경해주는 기준이 되는 항목(ex.code_idx1) 
 * code_find: 해당 엘리먼트에 세팅할 데이터의 명칭
 * area: 라디오버튼이 표현되는 영역
 * selectCond: 값이 있을경우 선택된 상태로 표기하기 위해 참조하는 엘리먼트 명
 * blankCond: 콤보박스에서 첫번째 항목에 넣을 명칭.
 * lang: 언어 (en/kr)
 * 
 * - base_follower, base_codeFind는 서브콤보가 상위콤보의 값에 따라 바뀔때 상위콤보의 키값인 
 *  'minor_cd'외에 다른 컬럼(엘리먼트)을 참조하여 변경 이벤트를 발생 시키기 위해 사용.  
 * 
 * base_follower: 서브콤보에 영향을 미치는 상위콤보에서 비교 참조할 상위 콤보의 컬럼(어트리뷰트)명
 * base_codeFind: 서브콤보에 영향을 미치는 상위콤보에 세팅되는 데이터 명칭.
*/

//json type의 특수문자 javascript에서 컨트롤 할 수 있도록 convert
function convertJsonType(data){
//	data = data.replace(/&quot;/gi,'\"').replace(/&#39;/gi,'\'');
    data = jQuery.parseJSON(data);
    return data;
}

/*
 * 단일 콤보박스
 */ 
function Combo(map){
	var data = map.data;
    var code_find = map.code_find;
	var name_ref = map.name;
	var selectCond_ref = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
//	data = convertJsonType(data);

    name_ref = $('select[name='+name_ref+']');
    selectCond_ref = $('input[name='+selectCond_ref+']');
    
    name_ref.children('option').remove();
    
    var name;
    var selectCond;
    
    lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
    
    for(var k=0 ; selectCond_ref.length>k ; k++){
		if(selectCond_ref.length > 1){
			name = name_ref.eq(k);
			selectCond = selectCond_ref.eq(k);
		}else{
			name = name_ref;
			selectCond = selectCond_ref;
		}
		
	    if(undefined != blankCond && '' != blankCond){
	    	name.append("<option value=''>"+blankCond+"</option>");
	    }else if('' == blankCond){
	    	name.append("<option value=''></option>");
	    }
	    $.each(data[code_find], function(i, obj){
    		if(lang.indexOf('in') > -1 && obj.CODE_NM2 != undefined){
    			name.append("<option value='"+obj.MINOR_CD+"'>"+obj.CODE_NM2+"</option>");
    		}else{
    			if(obj.CODE_NM1 != undefined)
    			name.append("<option value='"+obj.MINOR_CD+"'>"+obj.CODE_NM1+"</option>");
    		}
			if(selectCond.val() == obj.MINOR_CD){
				if(undefined != blankCond && null != blankCond){
					name.children('option').eq(i+1).prop('selected', 'selected');             
			    }else{
			    	name.children('option').eq(i).prop('selected', 'selected');
			    }
			}
	    });
    }
}

/*
 * 단일 콤보박스 세팅 by Object
 */ 
function ComboByObj(map){
	var data = map.data;
	var code_find = map.code_find;
	var targetObj = map.targetObj;
	var selectVal = map.selectVal;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
	$(targetObj).children('option').remove();
	
	lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
	
		
	var optionsHtml = '';
	
	if(undefined != blankCond && '' != blankCond){
		optionsHtml = "<option value=''>"+blankCond+"</option>";
	}else if('' == blankCond){
		optionsHtml = ("<option value=''></option>");
	}
	
	$.each(data[code_find], function(i, obj){
		var code_nm = obj.CODE_NM1;
		var selectedAttr = '';
		lang.indexOf('in') > -1 ? code_nm = obj.CODE_NM2 : code_nm = obj.CODE_NM1;
		if( selectVal.length > 0 && selectVal == obj.MINOR_CD ){
			selectedAttr = 'selected="selected"';
		}
		optionsHtml += ("<option value='"+obj.MINOR_CD+"' "
				+ "code_idx1='" + obj.CODE_IDX1 + "' "
				+ "code_idx2='" + obj.CODE_IDX2 + "' "
				+ "code_idx3='" + obj.CODE_IDX3 + "' "
				+ "code_idx4='" + obj.CODE_IDX4 + "' "
				+ selectedAttr +">"+code_nm+"</option>");
	});
	$(targetObj).append(optionsHtml);
}

/*
 * 단일 콤보박스 성능 개선
 */ 
function Combo2(map){
	var data = map.data;
    var code_find = map.code_find;
	var name_ref = map.name;
	var selectCond_ref = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	var flag = map.flag; 
	
    name_ref = $('select[name='+name_ref+']');
    selectCond_ref = $('input[name='+selectCond_ref+']');
    
    name_ref.children('option').remove();
    
    var name;
    var selectCond;
    
    lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
    
    for(var k=0; selectCond_ref.length>k; k++){
		if(selectCond_ref.length > 1){
			name = name_ref.eq(k);
			selectCond = selectCond_ref.eq(k);
		}else{
			name = name_ref;
			selectCond = selectCond_ref;
		}
		
		var optionsHtml = '';
		
	    if(undefined != blankCond && '' != blankCond){
	    	optionsHtml = "<option value=''>"+blankCond+"</option>";
	    }else if('' == blankCond){
	    	optionsHtml = ("<option value=''></option>");
	    }
	    $.each(data[code_find], function(i, obj){
	    	console.log();
	    	var code_nm = obj.CODE_NM1;
	    	var selectedAttr = '';
	    	if(code_find == 'CTRY_CD') code_nm = obj.CODE_IDX2;
	    	else lang.indexOf('in') > -1 ? code_nm = obj.CODE_NM2 : code_nm = obj.CODE_NM1;
	    	if( selectCond.val().length > 0 && selectCond.val() == obj.MINOR_CD ){
	    		selectedAttr = 'selected="selected"';
	    	}
//	    	if(data[code_find][i].CODE_IDX5 == 'Y' && (code_nm != undefined && code_nm != '')){
//	    		optionsHtml += ("<option value='"+obj.MINOR_CD+"' " + selectedAttr +">"+ flag + code_nm +" (" + obj.MINOR_CD + ")</option>");
//	    	}
//	    	if(data[code_find][i].CODE_IDX5 == 'Y'){
//	    		optionsHtml += ("<option value='"+obj.MINOR_CD+"' " + selectedAttr +">"+ flag + code_nm +" (" + obj.MINOR_CD + ")</option>");
//	    	}
	    	if(code_nm == undefined || code_nm == '' || obj.MINOR_CD == '' || obj.MINOR_CD == undefined ){
	    		optionsHtml += ("<option value='"+obj.MINOR_CD+"' " + selectedAttr +"> blank  </option>");
	    	}else{
	    		optionsHtml += ("<option value='"+obj.MINOR_CD+"' " + selectedAttr +">(" + obj.MINOR_CD + ") " + flag + code_nm +"</option>");
	    	}
	    });
	    name.append(optionsHtml);
    }
}

/*
 *  단일 콤보박스의 서브 콤보박스.
 *  단일 콤보박스 어트리뷰트(base_target)와 서브콤보의 
 *  참조대상인 follower(code_idx)를 기준으로 서브콤보가 구성됨.
 *  속도개선 2016.11.10
*/
function SubCombo2(map){
	var data = map.data;
	var base_target = map.base_target;
	var name = map.name;
	var follower = map.follower;
	var code_find = map.code_find; 
	var selectCond = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
//    data = convertJsonType(data);
    
    name = $('select[name='+name+']');
    base_target = $('select[name='+base_target+']');
    selectCond = $('input[name='+selectCond+']');
    
	if(selectCond.length > 1){
		MultiSubCombo(map);
	}else{
		var currentEvent = base_target.onchange;

		base_target.change(function(){
	        if(currentEvent){
	            currentEvent();
	        }
	        
            name.children('option').remove();
            
            var optionsHtml = '';
            
    	    if(undefined != blankCond && '' != blankCond){
    	    	optionsHtml = "<option value=''>"+blankCond+"</option>";
    	    }else if('' == blankCond){
    	    	optionsHtml = ("<option value=''></option>");
    	    }
            
    	    name.append(optionsHtml);
            $.each(data[code_find], function(i, obj){
				appendOption2(map, data, obj, name, base_target, selectCond);
            });
            
            if(0 == name.prop('selectedIndex') || '' == base_target.val()){
            	selectCond.val('');
            	name.children('option').eq(0).prop('selected', 'selected');
            }
		});
		base_target.change();
	}
}

/*
 * 서브콤보 아이템 생성.
 * 서브콤보를 생성하는 펑션 내부에서 서브콤보의 아이템을 세팅하는데 사용된다. 
 * 속도개선 2016.11.10
 */
function appendOption2(map, data, obj, name, base_target, selectCond) {
	var follower = map.follower;
	var lang = map.lang;
	var base_follower = map.base_follower;
	var base_codeFind = map.base_codeFind;
	var base_target = base_target.val();
	var splitStr = new Array();
	
	var follwer_data = obj[follower];
	if('' == base_target){
		splitStr.push(follwer_data);
	}else{
		if(follwer_data.indexOf(',') > -1){
			follwer_data = follwer_data.substr(1, follwer_data.lastIndexOf(',')-1);
			splitStr = follwer_data.split(',');
		}else{
			splitStr.push(follwer_data);
		}
	}
	
	lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
	var optionsHtml = "";
	for(var i in splitStr) {
		if(undefined != base_codeFind && '' != base_codeFind && '' != base_target){
			$.each(data[base_codeFind], function(j, sub_obj){
				if(sub_obj['minor_cd'] == base_target){
					base_target = sub_obj[base_follower];
					return false;
				}
			});
		}
		
		if(base_target == splitStr[i] || '' == base_target){
	    	var code_nm = obj.CODE_NM1;
	    	var selectedAttr = '';
	    	lang.indexOf('in') > -1 ? code_nm = obj.CODE_NM2 : code_nm = obj.CODE_NM1;
	    	if( selectCond.val().length > 0 && selectCond.val() == obj.MINOR_CD ){
	    		selectedAttr = 'selected="selected"';
	    	}
	    	optionsHtml += "<option value='"+obj.MINOR_CD+"' " + selectedAttr +">"+code_nm+"</option>";
		}
	}
	name.append(optionsHtml);
}

/*
 * 라디오 버튼
 */
function Radio(map){
	var data = map.data; 
	var name = map.name;
	var code_find = map.code_find; 
	var selectCond_ref = map.selectCond;
	var blankCond = map.blankCond;
	var area = map.area;
	var lang = map.lang;
	
//	data = convertJsonType(data);
    
    area = document.getElementById(area).parentNode;
    
    lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
    
    var selectCond = $('input[name='+selectCond_ref+']');
    
    if(undefined != blankCond && '' != blankCond){
    	if('' == selectCond.val()){
    		area.innerHTML = '<input type="radio" class="radio_01"  id="'+name+'0" name="'+name+'" value="" onclick="setValue(\''+selectCond_ref+'\', this.value);" checked><label for="'+name+'0" style="" title=""><span></span>'+blankCond+'</label>';
    	}else{
    		area.innerHTML = '<input type="radio" class="radio_01"  id="'+name+'0" name="'+name+'" value="" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+'0" style="" title=""><span></span>'+blankCond+'</label>';
    	}
    }
    
    $.each(data[code_find], function(i, obj){
        if(selectCond.val() == obj.minor_cd){
    		if(lang.indexOf('in') > -1){
    			area.innerHTML += '<input type="radio" class="radio_01"  id="'+name+(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);" ><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM2+'</label>';
    		}else{
    			area.innerHTML += '<input type="radio" class="radio_01"  id="'+name+(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);" ><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM1+'<label>';
    		}
        }else{
    		if(lang.indexOf('in') > -1){
    			area.innerHTML += '<input type="radio" class="radio_01"  id="'+name+(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM2+'</label>';
    		}else{
    			area.innerHTML += '<input type="radio" class="radio_01"  id="'+name+(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM1+'</label>';
    		}
        }
        
        if(undefined != blankCond && '' != blankCond){
        	if((i != 0 && (i+2) % 5 == 0)){
        		area.innerHTML += '<br/>';
        	}
        }else{
        	if((i != 0 && (i+1) % 5 == 0)){
        		area.innerHTML += '<br/>';
        	}
        }
    });
}

/*
 * 체크 박스
 */
function Check(map){
	var data = map.data; 
	var name = map.name;
	var code_find = map.code_find; 
	var selectCond_ref = map.selectCond;
	var blankCond = map.blankCond;
	var area = map.area;
	var lang = map.lang;
	
//	data = convertJsonType(data);
	
	area = document.getElementById(area).parentNode;
	
	lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
	
	var selectCond = $('input[name='+selectCond_ref+']');
	
	if(undefined != blankCond && '' != blankCond){
		if('' == selectCond.val()){
			area.innerHTML = '<input type="checkbox" class="checkbox_01"  id="'+name+'0" name="'+name+'" value="" onclick="setValue(\''+selectCond_ref+'\', this.value);" checked><label for="'+name+'0" style="" title=""><span></span>'+blankCond+'</label>';
		}else{
			area.innerHTML = '<input type="checkbox" class="checkbox_01"  id="'+name+'0" name="'+name+'" value="" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+'0" style="" title=""><span></span>'+blankCond+'</label>';
		}
	}
	
	$.each(data[code_find], function(i, obj){
		if(selectCond.val() == obj.minor_cd){
			if(lang.indexOf('in') > -1){
				area.innerHTML += '<input type="checkbox" class="checkbox_01"  id="'+ name +(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM2+'</label>';
			}else{
				area.innerHTML += '<input type="checkbox" class="checkbox_01"  id="'+ name +(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM1+'<label>';
			}
		}else{
			if(lang.indexOf('in') > -1){
				area.innerHTML += '<input type="checkbox" class="checkbox_01"  id="'+ name +(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM2+'</label>';
			}else{
				area.innerHTML += '<input type="checkbox" class="checkbox_01"  id="'+ name +(i+1)+'" name="'+name+'" value="'+obj.MINOR_CD+'" onclick="setValue(\''+selectCond_ref+'\', this.value);"><label for="'+name+(i+1)+'" style="" title=""><span></span>'+obj.CODE_NM1+'</label>';
			}
		}
		
//		if(undefined != blankCond && '' != blankCond){
//			if((i != 0 && (i+2) % 5 == 0)){
//				area.innerHTML += '<br/>';
//			}
//		}else{
//			if((i != 0 && (i+1) % 5 == 0)){
//				area.innerHTML += '<br/>';
//			}
//		}
	});
}

/*
 * 서브콤보 아이템 생성.
 * 서브콤보를 생성하는 펑션 내부에서 서브콤보의 아이템을 세팅하는데 사용된다. 
*/
function appendOption(map, data, obj, name, base_target, selectCond) {
	var follower = map.follower;
	var lang = map.lang;
	var base_follower = map.base_follower;
	var base_codeFind = map.base_codeFind;
	var base_target = base_target.val();
	var splitStr = new Array();
	
	var follwer_data = obj[follower];
	if('' == base_target){
		splitStr.push(follwer_data);
	}else{
		if(follwer_data.indexOf(',') > -1){
			follwer_data = follwer_data.substr(1, follwer_data.lastIndexOf(',')-1);
			splitStr = follwer_data.split(',');
		}else{
			splitStr.push(follwer_data);
		}
	}
	
	lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];

	for(var i in splitStr) {
		if(undefined != base_codeFind && '' != base_codeFind && '' != base_target){
			$.each(data[base_codeFind], function(j, sub_obj){
				if(sub_obj['minor_cd'] == base_target){
					base_target = sub_obj[base_follower];
					return false;
				}
			});
		}
		
		if(base_target == splitStr[i] || '' == base_target){
			if(lang.indexOf('in') > -1){
				name.append("<option value='"+obj.MINOR_CD+"'>"+obj.CODE_NM2+"</option>");
			}else{
				name.append("<option value='"+obj.MINOR_CD+"'>"+obj.CODE_NM1+"</option>");    		    		    			
			}
			
			if(selectCond.val() == obj.MINOR_CD){
				var size = name.children('option').size()-1;
				name.children('option').eq(size).prop('selected', 'selected');
			}
		}
	}
}

/*
 *  단일 콤보박스의 서브 콤보박스.
 *  단일 콤보박스 어트리뷰트(base_target)와 서브콤보의 
 *  참조대상인 follower(code_idx)를 기준으로 서브콤보가 구성됨.
*/
function SubCombo(map){
	var data = map.data;
	var base_target = map.base_target;
	var name = map.name;
	var follower = map.follower;
	var code_find = map.code_find; 
	var selectCond = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
//    data = convertJsonType(data);
    
    name = $('select[name='+name+']');
    base_target = $('select[name='+base_target+']');
    selectCond = $('input[name='+selectCond+']');
    
	if(selectCond.length > 1){
		MultiSubCombo(map);
	}else{
		var currentEvent = base_target.onchange;

		base_target.change(function(){
	        if(currentEvent){
	            currentEvent();
	        }
	        
            name.children('option').remove();
            
            if(undefined != blankCond && '' != blankCond){
            	name.append("<option value=''>"+blankCond+"</option>");             
            }else if('' == blankCond){
            	name.append("<option value=''></option>");
            }
            
            $.each(data[code_find], function(i, obj){
				appendOption(map, data, obj, name, base_target, selectCond);
            });
            
            if(0 == name.prop('selectedIndex') || '' == base_target.val()){
            	selectCond.val('');
            	name.children('option').eq(0).prop('selected', 'selected');
            }
		});
		base_target.change();
	}
}

/*
 *  그리드 서브콤보.
 *  그리드 형태에서 배열로 다수의 엘리먼트가 생성되었을때 사용된다.
*/
function MultiSubCombo(map){
	var data = map.data;
	var base_target_ref = map.base_target;
	var name_ref = map.name;
	var follower = map.follower;
	var code_find = map.code_find; 
	var selectCond_ref = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
//    data = convertJsonType(data);
    
    name_ref = $('select[name='+name_ref+']');
    base_target_ref = $('select[name='+base_target_ref+']');
    selectCond_ref = $('input[name='+selectCond_ref+']');
    
    var name;
    var base_target;
    var selectCond;
    
    for(var k=0; selectCond_ref.length>k; k++){
		if(selectCond_ref.length > 1){
			name = name_ref.eq(k);
			base_target = base_target_ref.eq(k);
			selectCond = selectCond_ref.eq(k);
		}else{
			name = name_ref;
			base_target = base_target_ref;
			selectCond = selectCond_ref;
		}
    
        name.children('option').remove();
        
        if(undefined != blankCond && '' != blankCond){
        	name.append("<option value=''>"+blankCond+"</option>");             
        }else if('' == blankCond){
        	name.append("<option value=''></option>");
        }
        $.each(data[code_find], function(i, obj){
			appendOption(map, data, obj, name, base_target, selectCond);
        });
        
        if(0 == name.prop('selectedIndex')){
        	selectCond.val('');
        }
    }
}

/*
 *  서브콤보 이벤트
 *  단일콤보의 변화에 따라 이벤트가 발생하여 서브콤보를 다시 세팅할때 사용된다.
*/
function SubComboEvent(map, idx){
	var data = map.data;
	var base_target = map.base_target;
	var name = map.name;
	var follower = map.follower;
	var code_find = map.code_find; 
	var selectCond = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
//    data = convertJsonType(data);
	
    name = $('select[name='+name+']').eq(idx);
    base_target = $('select[name='+base_target+']').eq(idx);
    
    selectCond = $('input[name='+selectCond+']').eq(idx);
    
    name.children('option').remove();
    
    if(undefined != blankCond && '' != blankCond){
    	name.append("<option value=''>"+blankCond+"</option>");
    }else if('' == blankCond){
    	name.append("<option value=''></option>");
    }
    
    $.each(data[code_find], function(i, obj){
		appendOption(map, data, obj, name, base_target, selectCond);
    });
    
    if(0 == name.prop('selectedIndex')){
    	selectCond.val('');
    }
}

/*
 *  콤보박스 값 세팅
 *  콤보박스의 변화에 따라 변경값을 대상(bindee)에 세팅하는데 사용된다.
 *  그리드의 경우 3번째 파라메터를 입력하여야 한다.
*/
function setValue(bindee, value, i){
	var name = $('input[name='+bindee+']');
	
	if(name.length > 1){
		name.eq(i).val(value);
	}else{
		name.val(value);
	}
}

/*
 * system_cd: 콘텐츠 명칭 (ex. ATV, ACR, TCO)
 * code_find: 찾을 데이터의 코드 텍스트 명칭
 * order: 정렬방식
 * list_yn: 리턴방식 결정 (Y: JSON, N: plain text)
*/


/*
 *  비동기 ajax 호출
 *  비동기 방식의 AJAX를 호출할 때 사용된다.
 *  
*/
function sendRequest(obj){
//	var params = {};
//	
//	if(obj.condition != undefined && obj.condition != null){
//		params['condition'] = obj.condition;
//	}
	
	$.ajax({
		type : 'POST',
		url : obj.action,
		dataType: 'json',
		data : obj.params,
	    success: function(responseData, textStatus, jqXHR){
//	    	if('Y' == obj.list_yn){
	    		obj.callbackFunc(responseData, obj.callbackParams);
//	    		eval(obj.callbackFunc+'(JSON.stringify(responseData))');
//	    	}else{
//	    		eval(obj.callbackFunc+'(JSON.parse(responseData).'+obj.code_find+'[0])');
//	    	}
	    },
	    error : function(responseData, textStatus, errorThrown){
	    	alert(errorThrown);
	    }
	});
}

/*
 *  동기 ajax 호출
 *  동기 방식의 AJAX를 호출할 때 사용된다.
 *  
*/
function sendRequestSync(obj){
//	var params = {};
	
//	if(obj.condition != undefined && obj.condition != null){
//		params['condition'] = obj.condition;
//	}
//	
//	if(obj.params != undefined && obj.params != null){
//		params['condition'] = obj.condition;
//	}
	
	$.ajax({
		type : 'POST',
		url : obj.action,
		async : false,
		dataType: 'json',
		data : obj.params,
	    success: function(responseData, textStatus, jqXHR){
//	    	if('Y' == obj.list_yn){
	    		obj.callbackFunc(responseData, obj.callbackParams);
//	    		eval(obj.callbackFunc+'(JSON.stringify(responseData))');
//	    	}else{
//	    		eval(obj.callbackFunc+'(JSON.parse(responseData).'+obj.code_find+'[0])');
//	    	}
	    },
	    error : function(responseData, textStatus, errorThrown){
//	    	alert(errorThrown);
	    	obj.failCallbackFunc(responseData, textStatus, errorThrown);
	    }
	});
}

/*
 *  Common Grid Util
 *  공통 그리드를 생성하는 용도로 사용.
 *  
 *  //체크박스 컬럼 아이템
 *  var checkbox = {
 *  		//컬럼 아이템 종류
 *			type:'checkbox',
 *			//컬럼 아이템이 생성될 케이블 컬럼명
 *			target:'chk_item',
 *			//컬럼 아이템의 고유 접근 명칭
 *			name:'chk',
 *			//컬럼 아이템에 바인딩될 DB 컬럼 명(값으로 바인딩).
 *			value:'minor_cd',
 *			//클릭 이벤트 펑션명
 *			event_click:'funChk',
 *			//클릭이벤트에서 받을 파라메터[배열타입]
 *			event_params:['major_cd', 'minor_cd']
 *		};
 *	//버튼 컬럼 아이템	
 *	var insert_button = {
 *		type:'button',
 *		target:'buton_blank',
 *		name:'item_insert',
 *		//버튼명칭
 *		text: 'insert',
 *		event_click:'goInsert',
 *		event_params:['major_cd', 'minor_cd'],
 *		//해당 버튼의 css
 *		css:'s_button',
 *		//조건문
 *		statement:{
 *			//비교대상이 되는 DB 컬럼명
 *			name:['major_cd','minor_cd'],
 *			//두개이상의 조건일경우 조건 연결 연산자
 *			link: '&&',
 *			//DB컬럼명
 *			major_cd : {
 *				//비교 연산자
 *				symbol : '==',
 *				//설정 값
 *				value : '000'
 *			},
 *			minor_cd : {
 *				symbol : '==',
 *				value : '001'	
 *			}
 *		}
 *	};
*	 
 *	//그리드 생성 (그리드 생성(new)는 전역으로 생성하고 설정은 function내부에 함.)
 *	var list = new Grid();
*	 
 *	//그리드 기본값 설정
 *	list.setConfig({
 *		//전송 타입
 *		type:'POST',
 *		//생성된 그리드 명칭
 *		grid_obj: 'list',
 *		//데이터 접근 url
 *		url:'<%=contextLangPath%>/sys/codes/listData',
 *		//조회조건으로 사용될 form의 검색조건 name
 *		search_items:['search_major_cd','search_minor_cd','search_code_nm', 'search_code_idx1'],
 *		//값이 뿌려질 테이블의 ID
 *		data_table:'d_table',
 *		//페이지 설정
 *		page_items: {
 *			//현재페이지로 사용되는 hidden element ID,NAME
 *			page:'current_page', 
 *			//현재 페이지 depth로 사용되는 hidden element ID,NAME
 *			depth: 'current_page_depth'
 *		},
 *		//컬럼아이템
 *		column_items:[checkbox, insert_button, delete_button],
 *		//각 행에 생성될 hidden element
 *		hidden_param:{
 *			//대상이될 컬럼 앞에 붙을 텍스트
 *			// ex) hd_minor_cd, hd_major_cd가 됨
 *			pre_text:'hd',
 *			//히든의 대상이 될 컬럼
 *			params:['minor_cd','major_cd']
 *		},
 *		//각 컬럼의 텍스트 정렬
 *		text_align:{
 *			//chk_item의 이름을 갖는 컬럼을 가운데 정렬
 *			//값은 css로 정의.
 *			chk_item: 'center',
 *			major_cd : 'center',
 *			minor_cd : 'center'
 *		},
 *		//클릭시 발생되는 이벤트 펑션명
 *		event_click:'funEdit',
 *		//각 컬럼별로 클릭 이벤트를 적용할 컬럼 설정
 *		//all은 전체 배열타입으로 컬럼명을 적으면 해당 컬럼만 이벤트 대상 적용
 *		event_target:'all',
 *		//펑션에 전달될 파라메터. 컬럼의 값으로 전달
 *		event_params:['major_cd', 'minor_cd'],
 *		//한번에 보여질 페이지 갯수
 *		page_num:10,
 *		//한번에 보여질 행 개수
 *		item_num:10
 *	});
 *	// 컬럼별 css적용 세팅
 *	list.setStyle({
 *		//비교대상이 되는 DB 컬럼명
 *		name:['major_cd','minor_cd'],
 *		//적용될 컬럼의 명칭, 'all'이면 전체 행 적용
 *		target: ['minor_cd'],
 *		//조건문
 *		statement:[{
 *			//조건 연결 연산자
 *			link:'&&',
 *			major_cd : {
 *				//비교 연산자
 *				symbol : '==',
 *				value : '000'
 *			},
 *			minor_cd : {
 *				symbol : '==',
 *				value : '001'	
 *			},
 *			//적용될 css
 *			css: 'font_blue font_bold'
 *		},{
 *			minor_cd : {
 *				symbol : '==',
 *				value : '008'
 *			},
 *			css: 'font_left_shift'
 *		}]
 *	});
 *	//Grid 그리기 
 *  //true : 검색조건 입력 후 검색조건에 맞게 데이터가 다시 조회되어야 할 때 사용.
 *  //false : 페이지 정보가 유지된다(기본동작형태)
 *  //기본은 빈값이다. (false와 같음)
 *	list.draw(true or false);
 *  
*/
var sicc_result;
var Grid = function(){
	//그리드 생성 후 유지되는 config값
	this.sicc_obj;
	//그리드 생성 후 유지되는 style값
	this.style_obj;
	//현재 페이지
	this.current_page = 1;
	//현재 페이지 깊이
	this.current_page_depth = 0;
	//전체 페이지 깊이
	this.tot_page_depth = 0;
	//기본으로 보여지는 페이지 갯수
	this.page_num = 10;
	//기본으로 보여지는 행 갯수
	this.item_num = 10;
	
	this.setConfig = function(config){
		this.sicc_obj = config;
	}
	
	this.getConfig = function(){
		return this.sicc_obj;
	}
	
	this.setStyle = function(obj){
		this.style_obj = obj;
	}
	
	this.getStyle = function(){
		return this.style_obj;
	}
	
	this.setResult = function(result){
		sicc_result = result;
	}
	
	this.getResult = function(){
		return sicc_result;
	}
	
	this.setCurrentPage = function(page){
		this.current_page = page;
	}

	this.getCurrentPage = function(){
		return this.current_page;
	}

	this.setCurrentDepth = function(depth){
		this.current_page_depth = depth;
	}

	this.getCurrentDepth = function(){
		return this.current_page_depth;
	}
	//리스트가 불리기전 페이지 기본 세팅
	this.pagePreset = function(obj, event){
		var frm_page = document.getElementById(obj.page_items.page);
		var frm_depth = document.getElementById(obj.page_items.depth);
		
		if(true == event){
			createSpinner();
			this.setCurrentPage(1);
			this.setCurrentDepth(0);
			frm_page.value = 1;
			frm_depth.value = 0;
		}
		
		if(false == event){
			createSpinner();
		}
		if('' == frm_page.value && '' == frm_depth.value){
			this.setCurrentPage(1);
			this.setCurrentDepth(0);
			frm_page.value = 1;
			frm_depth.value = 0;
		}else if('' == frm_depth.value){
			this.setCurrentDepth(0);
			frm_depth.value = 0;
		}else{
			this.setCurrentPage(frm_page.value);
			this.setCurrentDepth(frm_depth.value);
		}
	}
	
	//페이지 그리기
	this.draw = function(event){
		this.pagePreset(this.sicc_obj, event);
		
		var params = new Object();
		var cmd_params = new Object();
		//검색조건에 해당하는 데이터 파라메터로 만들기
		for(var i=0;i<this.sicc_obj.search_items.length;i++){
			eval('params.'+this.sicc_obj.search_items[i]+'="'+document.getElementById(this.sicc_obj.search_items[i]).value+'"');
		}
		this.item_num = this.sicc_obj.item_num;
		this.page_num = this.sicc_obj.page_num;
		
		//페이지 알고리즘
		
		//작업중
		params.page = this.current_page;
//		params.page_st = (1 == this.current_page) ? 1 : ((this.current_page-1) * this.item_num) +1;
//		params.page_ed = (1 == this.current_page) ? (this.current_page * this.item_num)+1 : ((this.current_page * this.item_num)+1);
		// 2017-06-01: limit 추가
		params.limit = this.item_num;
		
		//페이지에 뿌려질 데이터 가져오기
		$.ajax({
			type : this.sicc_obj.type,
			url : this.sicc_obj.url,
			async : false,
			dataType: 'json',
			data : params,
		    success: this.setResult,
		    error : function(responseData, textStatus, errorThrown){
		    	alert(errorThrown);
		    }
		});
		this.GridGenerator(this.getResult());
		if(true == event || false == event){
			stop_spinner();			
		}
	}

	//실제 그리드 데이터 생성.
	this.GridGenerator = function(result){
		
		var entry = document.getElementById(this.sicc_obj.data_title);
		var table = document.getElementById(this.sicc_obj.data_table);
		var table_head = table.tHead;
		var tbody = table.tBodies[0] || document.createElement('tbody');
		var footer = table.tFoot || document.createElement('tfoot');
		var new_tr;
		var new_td;
		var cnt = 0;
		var order = new Map();
		var alignKeySet = this.sicc_obj.text_align ? Object.keys(this.sicc_obj.text_align) : false;
		
		var data;
		
		var list = result['list'] || result['data']['list'];
		
		var t_count = result['total_cnt'] ;
		
		for(var m=0; m<list.length; m++){
			data = list[m];
			//첫번째일 경우 모든 행 삭제하고 시작
			if(0 == m){
				for(var i=0; i<table_head.rows[m].cells.length;i++){
					order.put(i+1, table_head.rows[m].cells[i].getAttribute('id').toUpperCase());
				}
				
				while (tbody.rows.length> 0) {
					tbody.deleteRow(0);
				}
				
				while (footer.rows.length> 0) {
					footer.deleteRow(0);
				}
			}
			//이벤트 펑션에 넘겨질 파라메터 생성.
			var e_param_value = '';
			for(var i=0; i<this.sicc_obj.event_params.length; i++){
				e_param_value += '\''+data[this.sicc_obj.event_params[i].toUpperCase()]+'\'';
				
				if(i != this.sicc_obj.event_params.length-1){
					e_param_value += ',';
				}
			}
			//테이블 로우 생성
			new_tr = document.createElement('tr');
			
			for(var i=1; i<=order.size(); i++){
				new_td = document.createElement('td');
				//컬럼 정렬 css 적용
				if(this.sicc_obj.text_align){
					for(var j=0; j<alignKeySet.length; j++){
						if(order.get(i).toLowerCase() == alignKeySet[j].toLowerCase()){
							new_td.className += this.sicc_obj.text_align[alignKeySet[j].toLowerCase()];
						}
					}
				}
				//컬럼 아이템 생성
				if(this.sicc_obj.column_items){
					for(var j=0; j<this.sicc_obj.column_items.length; j++){
						if(this.sicc_obj.column_items[j].target.toUpperCase() == order.get(i)){
							new_td.innerHTML += this.appendGridItem(this.sicc_obj.column_items[j], data, m);
						}
					}					
				}
				//각 컬럼별 값 생성.
				if(null != data[order.get(i)] && undefined != data[order.get(i)]){
					if(toUpperCaseArray(this.sicc_obj.event_target).indexOf(order.get(i)) != -1 || this.sicc_obj.event_target == 'all'){
						new_td.innerHTML += this.getAtag(data[order.get(i)], this.sicc_obj.event_click, e_param_value);
					}else{
						new_td.innerHTML += data[order.get(i)];
					}
				}
				
				if(this.style_obj){
					this.renderStyle(new_td, data, order.get(i));					
				}
				
				if(1 == i && this.sicc_obj.hidden_param){
					new_td.innerHTML += this.appendHiddenParam(this.sicc_obj, data);				
				}
				new_tr.appendChild(new_td);
			}
			tbody.appendChild(new_tr);
			table.appendChild(tbody);
		}
		
		if(list.length <= 0){
			while (tbody.rows.length> 0) {
				tbody.deleteRow(0);
			}
			
			while (footer.rows.length> 0) {
				footer.deleteRow(0);
			}
		}
		else
		{
			//상단 타이틀 부분 total iteams 
			if(null != entry)
				entry.innerHTML = 'total: ' + t_count; 
		}
		
		//페이지 적용
		this.PageGenerate(table, table_head.rows[0].cells.length, t_count);
	}

	//컬럼 아이템 생성.
	this.appendGridItem = function(obj, data, idx){
		var e_param_value = '';
		var value='';
		if('checkbox' == obj.type) {
			for(var i=0; i<obj.event_params.length; i++){
				e_param_value += '\''+data[obj.event_params[i].toUpperCase()]+'\'';
				
				if(i != obj.event_params.length-1){
					e_param_value += ',';
				}
			}
			value = (undefined != obj.value) ? data[obj.value.toUpperCase()] : '';
			
			return this.getCheckbox(obj.name, value, obj.event_click, e_param_value, idx);
		} else if('button' == obj.type) {
			for(var i=0; i<obj.event_params.length; i++){
				e_param_value += '\''+data[obj.event_params[i].toUpperCase()]+'\'';
				
				if(i != obj.event_params.length-1){
					e_param_value += ',';
				}
			}
			
			value = (undefined != obj.value) ? data[obj.value.toUpperCase()] : '';
			
			return this.getButton(obj, data, obj.name, obj.event_click, e_param_value);
		} else {
			return '';
		}
	}
	//컬럼 hidden element 생성
	this.appendHiddenParam = function(obj, data){
		var temp = '';
		for(var i=0; i<obj.hidden_param.params.length; i++){
			temp += this.getHiddenParam(obj.hidden_param.pre_text+'_'+obj.hidden_param.params[i], data[obj.hidden_param.params[i].toUpperCase()]);
		}
		return temp;
	}
	
	this.getHiddenParam = function(name, value){
		return '<input type="hidden" name="'+name+'" value="'+value+'"/>';
	}
	
	this.pageCapacitySet = function(capacity){
		this.item_num = capacity;
		this.sicc_obj.item_num = capacity;
		this.draw(this.sicc_obj);
	}

	//페이지 생성
	this.PageGenerate = function(table, colspan_cnt, total_cnt){
		var footer = table.tFoot || document.createElement('tfoot');
		var new_tr;
		var new_td;
		var new_div;
		
		var page_cnt = Math.ceil(total_cnt/this.item_num);
		this.tot_page_depth = (page_cnt==this.page_num) ? 0 : Math.floor(page_cnt/this.page_num);
		this.tot_page_depth = (0 == page_cnt%this.page_num) ? this.tot_page_depth - 1 : this.tot_page_depth; 
		
		new_tr = document.createElement('tr');
		new_td = document.createElement('td');
		new_td.setAttribute('colspan',colspan_cnt);
				
		footer.appendChild(new_tr);
		
		if(total_cnt != 0){
			new_div = document.createElement('div');
			new_div.setAttribute('class','pop_in_bottom');
			var new_div_pasing_no = document.createElement('div');
			new_div_pasing_no.setAttribute('class','pasing_01');
			new_div.appendChild(new_div_pasing_no);
			
			var page_tag = '';
			var page_offset = (this.current_page_depth*this.page_num);
			
			//가장 앞 페이지로 이동
			//단위 앞으로 이동
//			if(this.current_page_depth != 0){
				page_tag += '<a class="first" onclick="javascript:{'+this.sicc_obj.grid_obj+'.moveFirst();};">first</a>';
				page_tag += '<a class="prev" onclick="javascript:{'+this.sicc_obj.grid_obj+'.movePrev();};">prev</a>';
//			}
			
			page_tag += '<span>';
			//페이지 이동
			for(var i=(page_offset+1); i<=(page_cnt<(page_offset+this.page_num)?page_cnt:(page_offset+this.page_num)); i++){
				if(this.current_page == i) {
					page_tag += '<a class="on">'+i+'</a>';
				} else {
					page_tag += '<a class="" onclick="javascript:{'+this.sicc_obj.grid_obj+'.movePage('+i+');};">'+i+'</a>';
				}
			}
			page_tag += '</span>';
			//단위 뒤로이동
			//가장 뒷 페이지로 이동
//			if(this.current_page_depth != this.tot_page_depth){
				page_tag += '<a class="next" onclick="javascript:{'+this.sicc_obj.grid_obj+'.moveNext();};">next</a>';
				page_tag += '<a class="last" onclick="javascript:{'+this.sicc_obj.grid_obj+'.moveEnd('+page_cnt+');};">last</a>';
//			}
			
			new_div_pasing_no.innerHTML = page_tag;
			new_div.appendChild(new_div_pasing_no);
			
//			//추가 페이지 정보
//			var new_div_pasing_info = document.createElement('div');
//			new_div_pasing_info.setAttribute('class','pasing_info');
//			page_tag = ' Showing: ' + (page_offset+1) + ' to ' + (page_cnt<(page_offset+this.page_num)?page_cnt:(page_offset+this.page_num)) + ' of ' + total_cnt + ' items';
//			new_div_pasing_info.innerHTML = page_tag;
//			new_div.appendChild(new_div_pasing_info);
		}
		new_td.appendChild(new_div);
		new_tr.appendChild(new_td);

		footer.appendChild(new_tr);
		table.appendChild(footer);
	}
	
	this.movePage = function(page){
		this.current_page = page;
		document.getElementById(this.sicc_obj.page_items.page).value = this.current_page;
		this.draw(false);
	}
	this.movePrev = function(){
		if(parseInt(this.current_page_depth) != 0)
		{
			this.current_page_depth = parseInt(this.current_page_depth)-parseInt(1);
			document.getElementById(this.sicc_obj.page_items.depth).value = this.current_page_depth;
		}
		this.current_page = parseInt(this.current_page_depth*this.page_num)+parseInt(1);
		document.getElementById(this.sicc_obj.page_items.page).value = this.current_page;
		this.draw(false);
	}
	this.moveNext = function(){
		if(this.current_page_depth != this.tot_page_depth)
		{
			this.current_page_depth = parseInt(this.current_page_depth)+parseInt(1);
			document.getElementById(this.sicc_obj.page_items.depth).value = this.current_page_depth;
		}
		this.current_page = parseInt(this.current_page_depth*this.page_num)+parseInt(1);
		document.getElementById(this.sicc_obj.page_items.page).value = this.current_page;
		this.draw(false);
	}
	this.moveFirst = function(){
		this.current_page_depth = 0;
		document.getElementById(this.sicc_obj.page_items.depth).value = this.current_page_depth;
		this.current_page = 1;
		document.getElementById(this.sicc_obj.page_items.page).value = this.current_page;
		this.draw(false);
	}
	this.moveEnd = function(page_cnt){
		this.current_page_depth = this.tot_page_depth;
		document.getElementById(this.sicc_obj.page_items.depth).value = this.current_page_depth;
		this.current_page = page_cnt;
		document.getElementById(this.sicc_obj.page_items.page).value = this.current_page;
		this.draw(false);
	}
	//anchor tag 생성
	this.getAtag = function(text, event_method, event_param){
		if(null != event_method && '' != event_method){
			return '<a href="javascript:;" onclick="javascript:{'+event_method+'('+event_param+');};">'+text+'</a>';
		}else{
			return '<a href="javascript:;">'+text+'</a>';
		}
	}
	//checkbox 생성
	this.getCheckbox = function(name, value, event_method, event_param, idx){
		if(null != event_method && '' != event_method){
			if(undefined != value && null != value && '' != value){
				return '<input type="checkbox" name="'+name+'" value="'+value+'" onclick="javascript:{'+event_method+'('+event_param+');};"/>';
			}else{
				return '<input type="checkbox" name="'+name+'" value="'+idx+'" onclick="javascript:{'+event_method+'('+event_param+');};"/>';			
			}
		}else{
			if(undefined != value && null != value && '' != value){
				return '<input type="checkbox" name="'+name+'" value="'+value+'"/>';
			}else{
				return '<input type="checkbox" name="'+name+'" value="'+idx+'"/>';			
			}
		}
	}
	//button 생성
	this.getButton = function(obj, data, name, event_method, event_param){
		var o = obj;
		var state = o.statement;
		
		var syntax = '';
		var css = '';
		if(state){
			for(var i=0;i<state.name.length;i++){
				syntax += ' "'+data[state.name[i].toUpperCase()]+'"'+state[state.name[i]].symbol+'"'+state[state.name[i]].value+'" ';
				
				if(null != state[state.name[i+1]] && null != state.link){
					syntax += state.link;
				}
			}
			
			if(syntax != ''){
				css += ' '+eval(syntax +'?"'+o.css+'":"";');				
			}
			
			if("" != css.trim()) {
				if(null != event_method && '' != event_method) {
					return '<span class="'+css+'" name="'+name+'" id="'+name+'" onclick="javascript:{'+event_method+'('+event_param+');};">'+o.text+'</span>';			
				} else {
					return '<span class="'+css+'" name="'+name+'" id="'+name+'">'+o.text+'</span>';			
				}
			} else {
				return '';
			}
				
		}else{
			css = o.css;
			if(null != event_method && '' != event_method) {
				return '<span class="'+css+'" name="'+name+'" id="'+name+'" onclick="javascript:{'+event_method+'('+event_param+');};">'+o.text+'</span>';			
			} else {
				return '<span class="'+css+'" name="'+name+'" id="'+name+'">'+o.text+'</span>';			
			}
		}
	}
	//Grid data 삭제
	this.deleteGrid = function(obj){
		var params = new Object();
		var chk = document.getElementsByName(obj.chk);
		var flag = 0;
		
		for(var i=0; i<obj.params.length; i++){
			var temp = document.getElementsByName(obj.params[i]);
			
			if(undefined == chk) {
				alert('no data');
				return false;
			} else if(chk.length > 1) {
				
				var arr_ele = new Array();
				
				for(var j=0; j<chk.length; j++){
					if(true == chk[j].checked){
						var ele = new Object();
						flag = 1;
						
						arr_ele.push(temp[j].value);
					}
				}
				
				eval('params.'+obj.params[i]+'=arr_ele;');
				
			} else {
				if(chk.checked == true){
					flag = 1;
				}
			}
		}
		
		if(0 == flag){
			alert((obj.uncheck_msg || 'select delete item'));
			return false;
		}else{
			if(confirm((obj.confirm_msg || 'delete?'))){
				$.ajaxSettings.traditional = true;
				$.ajax({
					type : 'POST',
					url : obj.url,
					async : false,
					dataType: 'json',
					data : params,
				    success: function(responseData, textStatus, jqXHR){
				    	messageController(responseData);
				    },
				    error : function(responseData, textStatus, errorThrown){
				    	messageController(responseData);
				    }
				});
				this.draw();
			}
		}
	}
	
	//style 적용
	this.renderStyle = function(td, data, key){
		var syntax = '';
		
		var state = this.style_obj.statement;
		var obj = this.style_obj;
		var style_css = '';
		
		for(var i=0; i<state.length; i++){
			syntax = '';
			for(var j=0; j<obj.name.length; j++){
				if(obj.target == 'all') {
					if(null != state[i][obj.name[j]]){
						syntax += ' "'+data[obj.name[j].toUpperCase()]+'"'+state[i][obj.name[j]].symbol+'"'+state[i][obj.name[j]].value+'" ';
					}
					
					if(null != state[i][obj.name[j+1]] && null != state[i].link){
						syntax += state[i].link;
					}					
				} else {
					if(obj.target.indexOf(key.toLowerCase()) != -1){
						if(null != state[i][obj.name[j]]){
							syntax += ' "'+data[obj.name[j].toUpperCase()]+'"'+state[i][obj.name[j]].symbol+'"'+state[i][obj.name[j]].value+'" ';
						}
						
						if(null != state[i][obj.name[j+1]] && null != state[i].link){
							syntax += state[i].link;
						}
					}
				}
			}
			if(syntax != ''){
				style_css += ' '+eval(syntax +'?"'+state[i].css+'":"";');				
			}
		}
		td.className += style_css;
	}
}

detailController = function(obj){
	var form = this.serialize(obj.form);
	$.ajax({
		type : 'POST',
		url : obj.url,
		async : false,
		dataType: 'json',
		data : form,
	    success: function(responseData, textStatus, jqXHR){
	    	messageController(responseData);
	    	detailService(obj, responseData);
	    },
	    error : function(responseData, textStatus, errorThrown){
	    	messageController(responseData);
	    }
	});
}

messageController = function(result){
	if(null != result.sicc_gms_message && '' != result.sicc_gms_message){
		MessageHolder(result.sicc_gms_message, result.msgShowType);
	}else{
		MessageHolder(result.sicc_gms_message, result.msgShowType);
	}
}

detailService = function(obj, result){
	var keySet = Object.keys(obj.keySet);
	
	obj.form.cmd.value = result.cmd;
	
	for(var i=0; i<keySet.length; i++){
		obj.form[keySet[i]].value = result[obj.keySet[keySet[i]]];
	}
}

MessageHolder = function(text, popup){
	var item = document.getElementById("sicc_message") || false;
	
	if('P' == popup) {
		if(null != text && '' != text){
			alert(text);
		}
	} else if(item) {
		if(null != text && '' != text) {
			item.style.display = 'inline-block';
			item.innerHTML = text;
		} else {
			item.style.display = 'none';
			item.innerHTML = '';
		}
	}
}

serialize = function(form, evt){
    var evt    = evt || window.event;
    evt.target = evt.target || evt.srcElement || null;
    var field, query='';
    if(typeof form == 'object' && form.nodeName == "FORM"){
        for(var i=0; i<form.elements.length; i++){
            field = form.elements[i];
            if(field.name && field.type != 'file' && field.type != 'reset'){
                if(field.type == 'select-multiple'){
                    for(var j=0; j<form.elements[i].options.length; j++){
                        if(field.options[j].selected){
                            query += '&' + field.name + "=" + encodeURIComponent(field.options[j].value).replace(/%20/g,'+');
                        }
                    }
                }
                else{
                    if((field.type != 'submit' && field.type != 'button') || evt.target == field){
                        if((field.type != 'checkbox' && field.type != 'radio') || field.checked){
                            query += '&' + field.name + "=" + encodeURIComponent(field.value).replace(/%20/g,'+');
                        }   
                    }
                }
            }
        }
    }
    return query.substr(1);
}



function Map() {
	var map = {};
	map.value = {};
	map.getKey = function(id) {
		return id;
	};
	map.put = function(id, value) {
		var key = map.getKey(id);
		map.value[key] = value;
	};
	map.contains = function(id) {
		var key = map.getKey(id);
		if (map.value[key]) {
			return true;
		} else {
			return false;
		}
	};
	map.get = function(id) {
		var key = map.getKey(id);
		if (map.value[key]) {
			return map.value[key];
		}
		return null;
	};
	map.remove = function(id) {
		var key = map.getKey(id);
		if (map.contains(id)) {
			map.value[key] = undefined;
		}
	};
	map.size = function(){
	    var count = 0;
	    for (var prop in map.value) {
	        count++;
	    }
	    return count;
	};
	map.toString = function(){ 
        var temp = ''; 
        for(var i in map){   
            temp = temp + ',' + i + ':' +  map[i]; 
        } 
        temp = temp.replace(',',''); 
          return temp; 
    }

	return map;
}

function toUpperCaseArray(obj){
	for(var i=0; i<obj.length; i++){
		obj[i] = obj[i].toUpperCase();
	}
	return obj;
}

function toLowerCaseArray(obj){
	for(var i=0; i<obj.length; i++){
		obj[i] = obj[i].toLowerCase();
	}
	return obj;
}

function funCheckBoxM(frm) {
	for (var i = 0; i < frm.elements.length; i++) {
		var e = frm.elements[i];
		if ((e.name != 'checkbox') && (e.type == 'checkbox')) {
			e.checked = frm.checkbox.checked;
		}
	}
}

function stop_spinner(){
	var holder = document.getElementById('spinnerHolder') || false;
	if(holder){
		setTimeout(function(){
			holder.innerHTML = '';
		}, 0);
		
	}
}

function createSpinner(){
	var holder = document.getElementById('spinnerHolder') || false;
	if(holder){
		spinner = new Spinner({scale:3.0, color: "#A1AEB3"}).spin();
		holder.appendChild(spinner.el);
	}
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
		for (var i=0; i < digits - n.length; i++) {
			zero += '0';
		}
	}
  
	return zero + n;
}

function getUUID() {
	function s4() {
		return ((1 + Math.random()) * 0x10000 | 0).toString(16).substring(1);
	}
	return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
}


function idCheck(userID) {
    var checkMsg = '';
    // 길이
    if (userID.length < 6  ) {
    	checkMsg = 'input_id_length';
        return checkMsg;
    }
    
    //첫번째 단어는 영어
    var regType =/^[a-z]/i;
    if(!regType.test(userID))
    	checkMsg = 'input_id_first_word';
 

    return checkMsg;
}

function passwordCheck(userID, password, newPassword1, newPassword2) {
    var checkMsg = '';
    // 기존 비밀번호와 새 비밀번호 일치 여부
    if (password != newPassword1) {
        checkMsg = 'mismatch_password';
        return checkMsg;
    }
    // 재입력 일치 여부
//    if (newPassword1 != newPassword2) {
//    	checkMsg = 'mismatch_password';
//        return checkMsg;
//    }
    // 길이
    if (newPassword1.length < 8  ) {
    	checkMsg = 'input_password_length';
        return checkMsg;
    }
    
    //첫번째 단어는 영어
    var regType =/^[a-z]/i;
    if(!regType.test(newPassword1))
    	checkMsg = 'input_pw_first_word';
    
    //불가능한 문자
    if (newPassword1.search(/[*+,/:;<=>?[\]|]/g) != -1)
    {
    	checkMsg = 'input_special_character_password';
        return checkMsg;
    }
    
    //영어, 숫자, 정해진 특수문자만 가능
    var regType1 = /^[A-Za-z0-9!@#$%^&() ~=`{}".']*$/;
    if(!regType1.test(newPassword1))
    	checkMsg = 'input_password_type';

    return checkMsg;
}

function isContinuedValue(value) {
    var intCnt1 = 0;
    var intCnt2 = 0;
    var temp0 = "";
    var temp1 = "";
    var temp2 = "";
    var temp3 = "";

    for (var i = 0; i < value.length - 3; i++) {
        temp0 = value.charAt(i);
        temp1 = value.charAt(i + 1);
        temp2 = value.charAt(i + 2);
        temp3 = value.charAt(i + 3);

        if (temp0.charCodeAt(0) - temp1.charCodeAt(0) == 1 && temp1.charCodeAt(0) - temp2.charCodeAt(0) == 1 && temp2.charCodeAt(0) - temp3.charCodeAt(0) == 1) {
            intCnt1 = intCnt1 + 1;
        }

        if (temp0.charCodeAt(0) - temp1.charCodeAt(0) == -1 && temp1.charCodeAt(0) - temp2.charCodeAt(0) == -1 && temp2.charCodeAt(0) - temp3.charCodeAt(0) == -1) {
            intCnt2 = intCnt2 + 1;
        }
    }

    return (intCnt1 > 0 || intCnt2 > 0);
}

/**
 * 이미지 Validate
 * 
 * @param input : 파일객체
 * @returns {Boolean}
 */
function imageValidate(input){
	var returnFlag = true;
	var fileName = input.files[0].name;
	var originalFileName = fileName.substr(0,fileName.lastIndexOf('.'));
	
    if(originalFileName.length > 90){
    	alert('파일명이 너무 깁니다.\n(The file name is too long.)');
    	returnFlag = false;
    	return
    }
    
    if( input.value != "" ){
    	if(!extChk(input, 'image')) return;
    }
	
	return returnFlag;
}

/**
 * 첨부파일 확장자 체크
 * 
 * @param input : 파일객체
 * @param fileType : 파일유형
 * @returns {Boolean}
 */
function extChk(input, fileType){
	var returnFlag = true;
	var msg = '';
	
	if( input.value != "" ){
		var ext = input.value.split('.').pop().toLowerCase();
		if(fileType == 'image'){
			if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
				msg = 'gif, png, jpg, jpeg';
				returnFlag = false;
			}
		}else if(fileType == 'excel'){
			if($.inArray(ext, ['xls','xlsx']) == -1) {
				msg = 'xls, xlsx'
				returnFlag = false;
			}
		}else if(fileType == 'zip'){
			if($.inArray(ext, ['zip']) == -1) {
				msg = 'zip'
				returnFlag = false;
			} 
		}else if(fileType == 'runner'){
			if($.inArray(ext, ['pdf','xls','xlsx','hwp','doc','docx']) == -1) {
				msg = 'pdf,xls,xlsx,hwp,doc,docx'
				returnFlag = false;
			} 
		}
	}
	
	if(!returnFlag){
		alert('확장자가 ' + msg + ' 인 파일만 첨부 가능합니다.\n확장자를 확인해주세요.\n(Only the ' + msg + ' extension can be attached. Please check the extension.)');
		input.value = '';
		return
	}
	
	return returnFlag;
}

/**
 * 문서 title 세팅
 * 
 * @param title : title
 * @returns 
 */
function setTitle( titleStr ){
	var windowTitle = "";
	var title = $(document).find('title').html();
	//기본title 구성     현제페이지 title - html title(ex 회원가입 - 레이트카드 )
	var pageTitle = $('.page-title').html();
	var tabTitle = $('.tab-title').find('li.active').find('a').text();
	if( tabTitle != null && tabTitle.length > 0 ){
		windowTitle = tabTitle + ' - ';
	}
	if( pageTitle != null && pageTitle.length > 0 ){
		windowTitle = windowTitle + pageTitle + ' - ';
	}
	windowTitle = windowTitle + title;
	if(titleStr != null && titleStr.length > 0){
		//title을 직접 세팅 하는경우
		windowTitle = titleStr;
	}
	$(document).find('title').html(windowTitle);
}

//enter input text -> selected
function setDualSelect(name, sel_name){
	var obj = $('input[name='+name+']');
	var value = obj.val();
	var sel_obj = $('select[name='+sel_name+']');
	var options = $('select[name='+sel_name+'] option');		// ex) var options = $('#sel_search_category_cd option');
	var isExistent = false;
	
	options.each(function(){
		var option = $(this).val();
		
		// 선택된 값이랑 option 비교하기
		if(value.toUpperCase() == option.toUpperCase()){
			//sel_obj.val(option);	// select 값 선택 			ex) sel_obj.val(option).prop("selected", true);
			$('select[name='+sel_name+']').val(option);
			isExistent = true;			// 해당 값 있음 표시
			return false;			
		}
	});
	
	if(!isExistent){
		alert("[" + value + "] There is no data.");
		sel_obj.val('');	// select 빈값 선택
		obj.val('');		// input  빈값 선택
		//return;
	}
	
	sel_obj.change();
}

function setRadioCheckValue(radioName, value){
	$('input:radio[name='+radioName+']:input[value="'+value+'"]').attr('checked', true);
}

//Org List setting
function SubComboToOrg(map){
	var data = map.data;
	var base_target = map.base_target;
	var name = map.name;
	var follower = map.follower;
	var code_find = map.code_find; 
	var selectCond = map.selectCond;
	var blankCond = map.blankCond;
	var lang = map.lang;
	
	lang = (undefined != lang && '' != lang) ? lang : data['CMM_LANG'];
	
    name = $('select[name='+name+']');
    base_target = $('select[name='+base_target+']');
    selectCond = $('input[name='+selectCond+']');
    
	if(selectCond.length > 1){
		MultiSubCombo(map);
	}else{
		var currentEvent = base_target.onchange;

		base_target.change(function(){
	        if(currentEvent){
	            currentEvent();
	        }
	        // remove option 
            name.children('option').remove();
            
            var optionsHtml = '';
            
    	    if(undefined != blankCond && '' != blankCond){
    	    	optionsHtml = "<option value=''>"+blankCond+"</option>";
    	    }else if('' == blankCond){
    	    	optionsHtml = ("<option value=''></option>");
    	    }
    	    
    	 	// Org List by Category
//			var category_cd = $('input[name=category_cd]').val().toUpperCase();
    	    var category_cd = base_target.val().toUpperCase();
            
    	    // insert option
    	    $.each(data[code_find], function(i, obj){
    			var code_nm = obj.CODE_NM1;
    			var selectedAttr = '';
    			lang.indexOf('in') > -1 ? code_nm = obj.CODE_NM2 : code_nm = obj.CODE_NM1;
    			if( selectCond.val().length > 0 && selectCond.val() == obj.MINOR_CD ){
    				selectedAttr = 'selected="selected"';
    			}
    			
    			// obj.CODE_IDX1 에 ACRORGM.R_CATEGORY_CD 값 있음
    			code_idx1 = obj.CODE_IDX1;	// ComboByObj() 에서 code_idx1 attr setting
    			
       			if(code_idx1 != undefined && code_idx1 != '' ){
//       				console.log('indexOf: ', category_cd);
       				// 해당 org 만 option으로 구성
        			if( code_idx1.indexOf(category_cd) != -1 ){
        				optionsHtml += ("<option value='"+obj.MINOR_CD+"' "
            					+ "code_idx1='" + obj.CODE_IDX1 + "' "
            					+ "code_idx2='" + obj.CODE_IDX2 + "' "
            					+ "code_idx3='" + obj.CODE_IDX3 + "' "
            					+ "code_idx4='" + obj.CODE_IDX4 + "' "
            					+ selectedAttr +">"+code_nm+"</option>");
        			}
        		}
    			
    		});
    	    name.append(optionsHtml);
    	    
            if(0 == name.prop('selectedIndex') || '' == base_target.val()){
            	selectCond.val('');
            	name.children('option').eq(0).prop('selected', 'selected');
            }
		});
		base_target.change();
	}
}

//--------------------------------------------------------------------
//compare two date (dd/mm/yyyy)
//2005.06.01 Alex Park
//ex) compareDate('05/06/2005','06/06/2005') => true
//--------------------------------------------------------------------
function compareDate(start, end){
	var format = 'dd/mm/yyyy';
	return compareDate2(start, end, format);
}

function compareDate2(start, end, format){
	// start
	var sYear;
	var sMon;
	var sDay;
	// end
	var eYear;
	var eMon;
	var eDay;
	
	if (format == 'dd/mm/yyyy') {
		sYear = start.substr(6,4);
		sMon  = start.substr(3,2)-1;
		sDay  = start.substr(0,2);
		eYear = end.substr(6,4);
		eMon  = end.substr(3,2)-1;
		eDay  = end.substr(0,2);
	} else if (format == 'ddMonyyyy') {
		// real format : dd-mmm-yyyy
		sYear = start.substr(7,4);
		sMon  = start.substr(3,3);
		sMon  = funMonth(sMon) -1;
		sDay  = start.substr(0,2);
		 
		eYear = end.substr(7,4);
		eMon  = end.substr(3,3);
		eMon  = funMonth(eMon) -1;
		eDay  = end.substr(0,2);
	} else if (format == 'yyyy/mm/dd') {  //happycno update    
		sYear = start.substr(0,4);
		sMon  = start.substr(5,2);
		sMon  = funMonth(sMon) -1;
		sDay  = start.substr(8,2);
		 
		eYear = end.substr(0,4);
		eMon  = end.substr(5,2);
		eMon  = funMonth(eMon) -1;
		eDay  = end.substr(8,2);
	}
	
	var formmer = new Date(sYear, sMon, sDay);
	var latter   = new Date(eYear, eMon, eDay);
	
	if(formmer > latter){
		return false;
	} else {
		return true;
	}
}


/**
 * 셀렉트 박스 달력(년/월/일)
 * name - 셀렉트 박스 이름
 * num - 현재년도에서 플러스, 마이너스 년도
 */
function createDateSelectBox(name, num) {
	var dt = new Date();
	var c_id = document.getElementById(name + "_id");
	var inHtml = "";
	var currentYear = dt.getFullYear();
	var currentMonth = dt.getMonth() + 1;
	var currentDay = dt.getDate();
	var dt2 = new Date(currentYear, currentMonth, "");
	var intNum = parseInt(num);
	var optMonth = "";
	var optDay = "";
	var lastDay = dt2.getDate();
	//var selected = "";

	// date
	inHtml += " <select class='select_01' style='font-size: 16px; width:190px;' name='" + name + "_day' id='" + name + "_day'> ";
	inHtml += " <option value='' ></option>";
	//for(var i = 1; i <= lastDay; i++) {
	for(var i = 1; i <= 31; i++) {
		if(i >= 1 && i < 10) {
			optDay = "0" + i;
		} else {
			optDay = i;
		}

		inHtml += " <option value='" + optDay + "' >" + optDay + "</option>";
	}
	inHtml += " </select>";
	
	// month
	inHtml += " <select class='select_01' style='font-size: 16px; width:190px;' name='" + name + "_month' id='" + name + "_month' onchange='onchageDate(\"" + name + "\")'> ";
	inHtml += " <option value='' ></option>";
	for(var i = 1; i <= 12; i++) {
		if(i >= 1 && i < 10) {
			optMonth = "0" + i;
		} else {
			optMonth = i;
		}

		inHtml += " <option value='" + optMonth + "' >" + optMonth + "</option>";
	}
	inHtml += " </select>";

	// year
	inHtml += " <select class='select_01' style='font-size: 16px; width:190px;' name='" + name + "_year' id='" + name + "_year' onchange='onchageDate(\"" + name + "\")'> ";  
	inHtml += " <option value='' ></option>"; 
	for(var i = currentYear - intNum; i <= currentYear + intNum; i++) {
		if(i < 2000) inHtml += "<option value='" + i + "' >" + i + "</opton>";
	} 
	inHtml += " </select>";

	c_id.innerHTML = inHtml;
}

function onchageDate(name) {
	var optDay = "";
	// year, month, day SelectBox찾기
	selectYear = document.getElementById(name + "_year");
	selectMonth = document.getElementById(name + "_month");
	selectDay = document.getElementById(name + "_day");

	// 현재 년도와 월 구하기
	year = selectYear.options[selectYear.selectedIndex].value;
	month = selectMonth.options[selectMonth.selectedIndex].value;

	tmpDate = new Date(year, month, 0);

	selectedIndex = selectDay.selectedIndex;

	for(i = selectDay.length-1; i >= 0; i--) {
		selectDay.options[i] = null;
	}

	selectDay.options[0] = new Option('', '');

	for(i = 1; i <= tmpDate.getDate(); i++) {
		if(i >= 1 && i < 10) {
			optDay = "0" + i;
		} else {
			optDay = i;
		}
		selectDay.options[i] = new Option(optDay, optDay);
	}

	if(selectedIndex <= tmpDate.getDate()) {
		selectDay.options[selectedIndex].selected = true;
	} else {
		//selectDay.options[tmpDate.getDate()-1].selected = true;
		selectDay.options[tmpDate.getDate()].selected = true;
	} 
}

function verifyemail(emailAddr) {
	var isEmail = false;
	var email = emailAddr

	var regExp = /^[0-9a-zA-Z][0-9a-zA-Z\_\-\.\+]+[0-9a-zA-Z]@[0-9a-zA-Z][0-9a-zA-Z\_\-]*[0-9a-zA-Z](\.[a-zA-Z]{2,6}){1,2}$/;
	
	if (email.match(regExp) != null) {
	   isEmail = true;
	}
	else {
	   isEmail = false;
	}
	return isEmail;
}

function StrReplace ( args, ch1, ch2 ) {
    if (ch1 == ch2)  {  return args;  }
    while(args.indexOf(ch1) != -1) {
        args = args.replace(ch1,ch2);
    }
    return args;
}

function onlyNum(sel) {
	$(sel).val($(sel).val().replace(/[^0-9\.]/g,''));
}

function onlyNum2(sel) {
	var onlyNum = $(sel).val().replace(/[^0-9]/g,'');
	$(sel).val(onlyNum.replace(/(^0+)/,''));
}

function uploadFileCheck(F, obj, type) {
	// 
	pathpoint = obj.lastIndexOf('.');
	filepoint = obj.substring(pathpoint+1,obj.length);
	filetype = filepoint.toLowerCase();
	type = type.toLowerCase();
	
	
	if (type == 'xls')
	{
		if(filetype=='xls' || filetype=='xlsx') {
		} else {
			alert('You can upload only ' + type + ' files.');
			F.reset();
			return false;
		}
	} else if(filetype == type) {
		//F.preview.src = obj;
	} else {	 
		alert('You can upload only ' + type + ' files.');
		F.reset();
		return false;
	} 

}

function countChar(val,sel,maxLen) {
    var len = $(val).val().length;
    var max = parseInt(maxLen);
    if (len > max) {
      $(val).val($(val).val().substring(0, max));
    } else {
      $('#' + sel).text(max - len);
    }
  }

function getFileSize( fileObj ){
	var nBytes = 0,
	oFiles = fileObj.files;
	nFiles = oFiles.length;
	for (var nFileId = 0; nFileId < nFiles; nFileId++) {
		nBytes += oFiles[nFileId].size;
	}
	var sOutput = nBytes + " bytes";
	// optional code for multiples approximation
	for (var aMultiples = ["KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
		sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
	}
	// end of optional code
	return nBytes;
}

function getFileName( fileObj ) {
	if(window.FileReader){
	  var filename = fileObj.files[0].name
	}
	else {
	  var filename = $(fileObj).val().split('/').pop().split('\\').pop();
	}
	return filename;    	
}

function onCheckFileType( fileObj , fileFlag ){
	//허용 확장자 
	var fileFilter = "";
	var result = false;
	
	switch (fileFlag) {
 		case 'passport': //조치 일반 파일
 			fileFilter=/^.*\.(pdf)$/i;
 			break;
 		case 'photo'://조치 이미지 파일
 			fileFilter=/^.*\.(jpg)$/i;
			break;
 		default:
 			fileFilter=/^.*\.(jpg|png|jpeg|gif|bmp|wav|wma|avi|mp3|mp4|asf|mpeg|wmv|hwp|txt|doc|xls|ppt|xlsx|docx|pptx|pdf)$/i;
 			break;
		}
	console.log("fileObj.value :: ", fileObj.value);
	
	if(fileObj.value.match(fileFilter)){
		result = true;
	}else{
		result = false;
	}
	
	return result;
}

function fnTrim(obj){
	$(obj).val($(obj).val().trim());
}

function replaceBr(val,nm){
	console.log(val);
	console.log(nm);
	$("#"+nm).text(val);
	var desc_text = $("#"+nm).text();
	var convert_desc_text = desc_text.replace(/&lt;br\/&gt;/gi,'<br/>');
	$("#"+nm).html(convert_desc_text);
}