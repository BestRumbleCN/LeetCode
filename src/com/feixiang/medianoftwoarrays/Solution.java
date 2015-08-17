package com.feixiang.medianoftwoarrays;

public class Solution {
	// 二分查找
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int start1 = 0;
		int end1 = nums1.length - 1;
		int mid1 = (nums1.length + 1) / 2 - 1;
		int start2 = 0;
		int end2 = nums2.length - 1;
		int mid2 = (nums2.length + 1) / 2 - 1;
		int left = 0;
		double result;
		while (end1 - start1 > 1 || end2 - start2 > 1) {
			if(nums1[mid1] > nums2[mid2]){
				end1=mid1;
				start2=mid2;
			}
			if(nums1[mid1] < nums2[mid2]){
				end2=mid2;
				start1=mid1;
			}
			if(nums1[mid1] == nums2[mid2]){
				break;
			}
		}
		if(end1 - start1 == 1){
			mid1 = start1;
		}
		if(end2 - start2 == 1){
			mid2 = start2;
		}
		left = mid1+mid2;
		if((nums1.length + nums2.length)%2 == 1){
			if((nums1.length + nums2.length + 1)/2 - left == 3){
				if(nums1[mid1+1]> nums2[mid2+1]){
					result = nums1[mid1+1];
				}else
					result = nums2[mid1+1];
			}
			
			if((nums1.length + nums2.length + 1)/2 - left == 2){
				result = max(min(nums1,nums2),max(nums1,nums2));
			}
		}
		
		if((nums1.length + nums2.length)%2 == 0){
			if((nums1.length + nums2.length )/2 - left == 3){
				result = max(nums1,nums2)/2;
			}
			
			if((nums1.length + nums2.length)/2 - left == 2){
				result = max(min(nums1,nums2),max(nums1,nums2))/2;
			}
		}
	}
}
